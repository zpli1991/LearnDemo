package org.zpli.spring.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.zpli.spring.component.ComponentStart;
import org.zpli.spring.utils.SpringUtils;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @Description: TODO
 * @author: zpli
 * @Date: 2020/4/23 14:05
 */

@Component
public class ComponentManager implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired(required = false)
    List<ComponentStart> componentStarts;

    @PostConstruct
    public void init() {
        if (CollectionUtils.isEmpty(componentStarts)) {
            System.out.println("****************************");
        } else {
            componentStarts.stream().forEach(e -> System.out.println(e.getClass()));
        }
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        SpringUtils.setCtx(event.getApplicationContext());
    }

}
