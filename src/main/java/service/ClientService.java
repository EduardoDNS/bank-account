package service;

import model.Client;
import java.util.HashMap;
import java.util.Map;

public class ClientService {
    
    private Map<String, Client> clients = new HashMap<>();

    public Client registerClient(String name, String cpf){
        checkCpfAvailability(cpf);
        clients.put(cpf, new Client(name, cpf));
        return clients.get(cpf);
    }

    private void checkCpfAvailability(String cpf){
        if(clients.containsKey(cpf)){
            throw new IllegalArgumentException("Client already exists.");
        }
    }
}
