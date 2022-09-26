package com.example.restaurant.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class TableChartServiceImplTest {

    @Autowired private TableChartService tableChartService;

    @Test
    public void createShouldSaveTableChart() {
        var imagePath = "image.jpg";
        var countTableCharts = tableChartService.count();
        var tableChart = tableChartService.create(imagePath);
        assertThat(tableChartService.count()).isGreaterThan(countTableCharts);
        assertEquals(tableChart.getImage(), imagePath);
    }

    @Test
    public void createShouldReturnTableChart() {
        var imagePath = "image.jpg";
        var tableChart = tableChartService.create(imagePath);
        assertEquals(tableChart, tableChartService.getById(tableChart.getId()));
    }

    @Test
    public void findByIdShouldThrowTableChartNotFoundException() {
        assertThrows(TableChartServiceImpl.TableChartNotFoundException.class, () -> tableChartService.getById(23123));
    }

    @Test
    public void findByIdShouldReturnTableChart() {
        var imagePath = "image.jpg";
        var tableChart = tableChartService.create(imagePath);
        assertEquals(tableChart, tableChartService.getById(tableChart.getId()));
    }

    @Test
    public void countShouldReturnNumberOfTableCharts() {

        assertThat(tableChartService.count()).isGreaterThan(0);
    }

}
