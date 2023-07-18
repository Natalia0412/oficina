package com.example.oficina.controller.client;


import com.example.oficina.dto.client.ClientDto;
import com.example.oficina.dto.client.ClientDtoPagination;
import com.example.oficina.dto.client.ClientDtoResponse;
import com.example.oficina.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping()
    public ResponseEntity<ClientDtoResponse> addClient(@RequestBody ClientDto clientDto) {

        // return  new ResponseEntity<Client>(clientService.createClient(clientDto), HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.createClient(clientDto));
    }


    @GetMapping()
    public ResponseEntity<ClientDtoPagination> getCar(@RequestParam(required = false, defaultValue = "30") int limit, @RequestParam(required = false, defaultValue = "0") int offset) {
        return ResponseEntity.ok(clientService.getAll(limit, offset));
    }

    //    @GetMapping()
//    public ResponseEntity<List<Client>> getClient() {
////        Client client = (Client) SecurityContextHolder.getContext()
////                .getAuthentication().
//        return ResponseEntity.ok(clientService.getAll());
//    }
    @GetMapping("/{id}")
    public ResponseEntity<ClientDtoResponse> getClientById(@PathVariable String id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ClientDtoResponse> updatePartial(@PathVariable String id, @RequestBody ClientDto clientDto) {
        return ResponseEntity.ok(clientService.updatePartial(id, clientDto));
    }

}
