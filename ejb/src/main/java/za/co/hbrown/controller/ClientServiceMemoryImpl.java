package za.co.hbrown.controller;

import za.co.hbrown.entity.Client;
import za.co.hbrown.qualifiers.Production;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.inject.Named;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;

/**
 * Created with IntelliJ IDEA by henryb.
 *
 * @author <a href="mailto:henry.g.brown@gmail.com">henryb</a>
 * @version 0.1201502191323
 * @since 0.1201502191323
 */
@Stateless
@Production
public class ClientServiceMemoryImpl implements ClientService {

    @Inject
    private BeanManager manager;


    @PostConstruct
    public void init() {
        System.out.println("********************************");
        System.out.println("********************************");
        System.out.println("********************************");
//        final Set<Bean<?>> beans = manager.getBeans("foo");
        final Object o = new Object();
        final Set<Bean<?>> beans = manager.getBeans(Object.class);
        for (Bean<?> bean : beans) {
            System.out.printf("name=[%s] class=[%s] beanClass=[%s] types=[%s]%n",
                    bean.getName(), bean.getClass(), bean.getBeanClass(), bean.getTypes());
        }
        System.out.println("Number of beans: " + beans.size());
        System.out.println("********************************");
        System.out.println("********************************");
        System.out.println("********************************");
    }

    public Client get(Long id) {
        return new Client(id, "Client " + id);
    }

}
