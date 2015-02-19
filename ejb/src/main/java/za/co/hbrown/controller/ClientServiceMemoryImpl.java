package za.co.hbrown.controller;

import za.co.hbrown.entity.Client;

import javax.ejb.Stateless;

/**
 * Created with IntelliJ IDEA by henryb.
 *
 * @author <a href="mailto:henry.g.brown@gmail.com">henryb</a>
 * @version 0.1201502191323
 * @since 0.1201502191323
 */
@Stateless
public class ClientServiceMemoryImpl implements ClientService {

    public Client get(Long id) {
        return new Client(id, "Client " + id);
    }

}
