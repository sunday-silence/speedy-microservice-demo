package cn.speedyframework.ms.infra.eurekaserver.listener;

import com.netflix.appinfo.InstanceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

/**
 * desc
 * author cgx
 * date 2020-07-20 09:30
 */
@Slf4j
@Configuration
public class EurekaEventListener {

    @EventListener
    public void listenCanceledEvent(EurekaInstanceCanceledEvent event) {
        log.info("服务节点注销：{}[{}] {}", event.getAppName(), event.getServerId(), event.isReplication());
    }

    @EventListener
    public void listenRegisteredEvent(EurekaInstanceRegisteredEvent event) {
        InstanceInfo instance = event.getInstanceInfo();
        log.info("服务节点注册：{}[{}] {}", instance.getAppName(), instance.getInstanceId(), event.isReplication());
    }
}
