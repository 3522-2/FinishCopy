package com.example.yuan.RecycleView;

/**
 * create by YUAN
 * on 2018/12/25
 */
class Item {

              private int mImageResId;
             private String mTitle;

             Item(int imageResId, String title) {
                 mImageResId = imageResId;
                 mTitle = title;
             }

             public int getImageResId() {
                return mImageResId;
            }

             public void setImageResId(int imageResId) {
                 mImageResId = imageResId;
             }

             public String getTitle() {
                 return mTitle;
             }

             public void setTitle(String title) {
                 mTitle = title;
             }
}