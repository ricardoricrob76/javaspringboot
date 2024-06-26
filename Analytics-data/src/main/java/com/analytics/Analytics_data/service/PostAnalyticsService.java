package com.analytics.Analytics_data.service;

import com.analytics.Analytics_data.dto.CarPostDTO;
import org.springframework.stereotype.Service;

@Service
public interface PostAnalyticsService {

    public void saveDataAnalytics(CarPostDTO carPostDTO);
}
