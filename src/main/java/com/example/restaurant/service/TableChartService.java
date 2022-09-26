package com.example.restaurant.service;

import com.example.restaurant.model.TableChart;
public interface TableChartService {

    TableChart create(String image);

    long count();

    TableChart getById(long id);
}
