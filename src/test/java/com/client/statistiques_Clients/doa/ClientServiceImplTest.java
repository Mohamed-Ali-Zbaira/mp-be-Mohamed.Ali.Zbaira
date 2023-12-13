package com.client.statistiques_Clients.doa;

import com.client.statistiques_Clients.dao.ClientServiceImpl;
import com.client.statistiques_Clients.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceImplTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;

    @Test
    public void testGetClientById() {
    }

}
