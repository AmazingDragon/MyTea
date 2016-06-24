package com.xtu.amazingdragon.mytea.Bean;

import java.util.List;

/**
 * Created by Administrator on 2016/6/23 0023.
 */
public class ImageBean {
    /**
     * id : 5613
     * title : 茶百科androidV1.2新功能简介
     * name : 茶百科androidV1.2新功能简介
     * link : http://sns.maimaicha.com/news/detail/5613
     * content : 1、	更新页面布局，增加首次登陆提示页。
     2、	增加栏目导航，按照分类列表展示。
     * image : http://s1.sns.maimaicha.com/images/2013/04/18/b0a9fed6aaef278fb5061b194c63d088.jpg
     * image_s : http://s1.sns.maimaicha.com/images/2013/04/18/9866411d3f679484822a286d58975956.jpg
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String title;
        private String image_s;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImage_s() {
            return image_s;
        }

        public void setImage_s(String image_s) {
            this.image_s = image_s;
        }
    }
}
