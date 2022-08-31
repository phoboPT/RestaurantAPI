package com.example.restaurant.model;

public class TableChart {
    private int tabbleChartId;
    private String image;

    public TableChart(int tabbleChartId, String image) {
        this.tabbleChartId = tabbleChartId;
        this.image = image;
    }

    public int getTabbleChartId() {
        return tabbleChartId;
    }

    public void setTabbleChartId(int tabbleChartId) {
        this.tabbleChartId = tabbleChartId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "TableChart{" +
                "tabbleChartId=" + tabbleChartId +
                ", image='" + image + '\'' +
                '}';
    }
}
