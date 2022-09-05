package com.example.restaurant.service.modelService;

import com.example.restaurant.model.TableChartModel;
import com.example.restaurant.repository.TableChartRepository;
import org.springframework.stereotype.Service;
@Service
public class TableChartServiceImpl implements TableChartService {

    private final TableChartRepository tableChartRepository;

    public TableChartServiceImpl(TableChartRepository tableChartRepository) {
        this.tableChartRepository = tableChartRepository;
    }

    @Override
    public TableChartModel create(String name) {
        return tableChartRepository.save(new TableChartModel(name));
    }

    @Override
    public long count() {
        return tableChartRepository.count();
    }

    @Override
    public TableChartModel getById(long id) throws TableChartNotFoundException {
        return tableChartRepository.findById(id).orElseThrow(TableChartNotFoundException::new);
    }

    public static class TableChartNotFoundException extends RuntimeException {
    }
}
