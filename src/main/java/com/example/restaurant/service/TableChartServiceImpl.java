package com.example.restaurant.service;

import com.example.restaurant.model.TableChart;
import com.example.restaurant.repository.TableChartRepository;
import org.springframework.stereotype.Service;
@Service
public class TableChartServiceImpl implements TableChartService {

    private final TableChartRepository tableChartRepository;

    public TableChartServiceImpl(TableChartRepository tableChartRepository) {
        this.tableChartRepository = tableChartRepository;
    }

    @Override
    public TableChart create(String image) {
        return tableChartRepository.save(new TableChart(image));
    }

    @Override
    public long count() {
        return tableChartRepository.count();
    }

    @Override
    public TableChart getById(long id) throws TableChartNotFoundException {
        return tableChartRepository.findById(id)
                                   .orElseThrow(TableChartNotFoundException::new);
    }

    public static class TableChartNotFoundException extends RuntimeException {
    }
}
