package com.muse.web;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.muse.httpclient.HttpProcessException;
import com.muse.model.ConvergenceDetailAndDLModel;
import com.muse.model.MuseSongModel;
import com.muse.model.Result;
import com.muse.model.SongDLModel;
import com.muse.model.Songs;
import com.muse.service.HttpClientService;
import com.muse.support.Constants;
import com.muse.support.Constants.API;
import com.muse.support.RequestLimit;
import com.muse.support.ReturnResult;

@Controller
@RequestMapping("/muse")
public class MuseController {
	@Resource
	private HttpClientService httpClientService;

	/**
	 * 如果有RequestLimit这个注解的时候 那么 advice会返回一个视图结果 那么这个controller就不能用RestController了
	 * 
	 * @param songName
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/song")
	 @RequestLimit(count = 2)
	public ReturnResult<List<ConvergenceDetailAndDLModel>> searchBySongName(String songName) {
		ReturnResult<List<ConvergenceDetailAndDLModel>> returnResult = new ReturnResult<>();
		if (StringUtils.isEmpty(songName)) {
			returnResult.setCode(202);
			returnResult.setMsg("MAYDAY!MAYDAY!");
			return returnResult;
		}
		Map<String, String> map = new HashMap<>();
		map.put("type", "search");
		map.put("search_type", "1");
		map.put("s", songName);
		try {
			String result = httpClientService.doGet(API.BASE_SEARCH_API, map);
			MuseSongModel museSongModel = JSON.parseObject(result, MuseSongModel.class);
			if (museSongModel.getCode() != 200) {
				returnResult.setCode(museSongModel.getCode());
				returnResult.setMsg("MAYDAY!MAYDAY!");
				return returnResult;
			}
			if (museSongModel.getResult().getSongCount() == 0) {
				returnResult.setCode(201);
				returnResult.setMsg("没有该歌曲的信息");
				return returnResult;
			}
			Result resultObj = museSongModel.getResult();
			List<Songs> songs = resultObj.getSongs();
			/*
			 * subList 是返回一个镜像而不是新示例 用了 得保证原来的 list 不能更改。  之前的抛异常是因为更改了原来的 list 而要使用 sublist
			 * 的时候必然报异常。  clear 的这个跟这个问题说的是如何获得一个 list 的某一段顺便释放其他节点。  这个操作后原来的 list 会截取出来
			 * 类型不变。  而 subList 实际上返回的是 java.util.Sublist 或者 java.util.ArrayList.Sublist。
			 */
			if (songs.size() > 10) {
				songs.subList(songs.size() - 10, songs.size()).clear();
			}
			List<ConvergenceDetailAndDLModel> convergence = new ArrayList<>();
			songs.stream().forEach(e -> {
				ConvergenceDetailAndDLModel modle = new ConvergenceDetailAndDLModel();
				modle.setSongs(e);
				Map<String, String> params = new HashMap<>();
				params.put("type", "song");
				params.put("id", String.valueOf(e.getId()));
				params.put("br", Constants.API.BASE_KBS);
				try {
					TimeUnit.MILLISECONDS.sleep(2);
					String dlResult = httpClientService.doGet(API.BASE_SEARCH_API, params);
					SongDLModel dlmodel = JSON.parseObject(dlResult, SongDLModel.class);
					int code = dlmodel.getCode();
					if (code != 200) {
						return;
					}
					if (CollectionUtils.isEmpty(dlmodel.getData())) {
						return;
					}
					modle.setData(dlmodel.getData().get(0));
					convergence.add(modle);
				} catch (HttpProcessException es) {
					es.printStackTrace();
				} catch (URISyntaxException es) {
					es.printStackTrace();
				} catch (InterruptedException es) {
					es.printStackTrace();
				}
			});
			returnResult.setCode(200);
			returnResult.setDatas(convergence);
			returnResult.setMsg("ok");
			return returnResult;
		} catch (HttpProcessException e) {
			e.printStackTrace();
			returnResult.setCode(500);
			returnResult.setMsg("server error");
			return returnResult;
		} catch (URISyntaxException e) {
			e.printStackTrace();
			returnResult.setCode(500);
			returnResult.setMsg("server error");
			return returnResult;
		}
	}
}