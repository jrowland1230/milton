package com.milton.resourceserver.listener;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

public class StartupListener implements ApplicationListener<ApplicationReadyEvent> {
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

        //DataVehicleCache d = DataVehicleCache.getInstance();

    }
}
