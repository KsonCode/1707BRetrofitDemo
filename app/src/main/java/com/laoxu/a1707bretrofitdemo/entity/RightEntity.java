package com.laoxu.a1707bretrofitdemo.entity;

import java.util.List;

public class RightEntity {
    public String message;
    public String status;
    public List<Right> result;

    public static class Right{
        public String commodityId;
        public String commodityName;
        public String masterPic;
        public String price;
        public String saleNum;

    }
}
