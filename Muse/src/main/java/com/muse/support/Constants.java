package com.muse.support;

public class Constants {

	public interface API {
		/**
		 * 	type 类型  type=lyric 
		 * 	type=lyric 歌词
		 * 	type=song  歌
		 * 	type=comments 评论
		 *  type=detail 返回一些比较基本的信息，歌曲名歌曲 id，歌手名歌手 id，专辑封面图之类的
		 *  type=playlist 就可以用 type=playlist 来获取到这个歌单的相关信息，例如创建者的信息啊，封面图啊，歌单被播放的次数啊 歌单内所有歌曲的简略信息
		 *  type=search 后面需要紧跟参数 search_type，用来确定你到底需要搜个什么 
		 *    search_type 1单曲 后面紧跟 s=xxxxx 来指定搜索的关键字
		 *    			  10专辑
		 *    			  100歌手
		 *    			  1000歌单
		 *    			  1002用户
		 *    			  1004mv
		 *    			  1006歌词
		 *  			  1009主播电台
		 *  id 歌曲编号
		 *  br 比特采样率
		 *  
		 */
		/**
		 * 基础的搜寻api
		 */
		public static final String BASE_SEARCH_API = "https://api.imjad.cn/cloudmusic/";
		
		public static final String BASE_KBS="320000";
	}
}
