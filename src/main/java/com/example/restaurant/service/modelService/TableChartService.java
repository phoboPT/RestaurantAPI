package com.example.restaurant.service.modelService;

import com.example.restaurant.model.TableChartModel;
public interface TableChartService {

    TableChartModel create(String name);

    long count();

    TableChartModel getById(long id);
}
