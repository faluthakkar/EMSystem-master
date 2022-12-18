package com.example.EMSystem.Controller;

import com.example.EMSystem.Exception.ResourceAlreadyExits;
import com.example.EMSystem.Exception.ResourceNotFoundException;
import com.example.EMSystem.Service.*;
import com.example.EMSystem.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.*;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ConsumerController {
    @Autowired
    private ConsumerService consumerService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private ConnectionTypeService connectionTypeService;
    @Autowired
    private ConnectionService connectionService;

    @Autowired
    private BillService billService;

    //For Consumer

    //create rest api to save consumer
    @PostMapping("/consumer")
    public Consumer save(@RequestBody Consumer consumer){
        return consumerService.saveConsumer(consumer);
    }

    //rest api to get All consumers
    @GetMapping("/consumer")
    public List<Consumer> getAllConsumers(){
        return consumerService.getAll();
    }
    //rest api to get consumer by id
    @GetMapping("/consumer/{id}")
    public Optional<Consumer> getById(@PathVariable Integer id) throws ResourceNotFoundException {
        return consumerService.getById(id);
    }

    //rest api to delete by id
    @DeleteMapping("/consumer/{id}")
    public void deleteById(@PathVariable Integer id) throws ResourceNotFoundException {
        consumerService.deleteById(id);
    }

    //rest api to update consumer
    @PutMapping("/consumer/{id}")
    public Consumer update(@RequestBody  Consumer consumer, @PathVariable	Integer id) throws ResourceNotFoundException {
        return consumerService.update(consumer, id);
    }

    //for address
    @PostMapping("/address")
    public Address save(@RequestBody Address address) throws ResourceAlreadyExits {
        return addressService.saveAddress(address);
    }

    @GetMapping("/address")
    public List<Address> getAllAddress(){
        return addressService.getAll();
    }

    @DeleteMapping("/address/{id}")
    public void deleteAddressById(@PathVariable("id") int id) {
        addressService.deleteAddressById(id);
    }

    @PutMapping("/address/{id}")
    public Address updateAddress(@RequestBody Address address , @PathVariable("id") int id) throws ResourceNotFoundException {
        return addressService.updateAddress(address, id);
    }

    //for connection type

    @PostMapping("/connectionType")
    public ConnectionType save(@RequestBody ConnectionType connectionType) {
        return connectionTypeService.save(connectionType);
    }

    @GetMapping("/connectionType")
    public List<ConnectionType> getAllConnectionType(){
        return connectionTypeService.getAll();
    }

    @GetMapping("/connectionType/{id}")
    public Optional<ConnectionType> getByIdConnectionType(@PathVariable Integer id) throws ResourceNotFoundException {
        return connectionTypeService.getById(id);
    }

    @PutMapping("/connectionType/{id}")
    public ConnectionType update(@RequestBody  ConnectionType connectionType, @PathVariable	Integer id) throws ResourceNotFoundException {
        return connectionTypeService.update(connectionType, id);
    }


    //For Connections

    @PostMapping("/connection")
    public Connections save(@RequestBody Connections connections) {
        return connectionService.saveConnection(connections);
    }

    @GetMapping("/connection")
    public List<Connections> getAllConnection(){
        return connectionService.getAll();
    }

    @GetMapping("/connection/{id}")
    public Optional<Connections> getByIdConnection(@PathVariable Integer id) throws ResourceNotFoundException {
        return connectionService.getById(id);
    }

    @DeleteMapping("/connection/{id}")
    public void delete(@PathVariable Integer id) throws ResourceNotFoundException {
        connectionService.deleteById(id);
    }


    //for bill

    @PostMapping("/bill")
    public Bill save(@RequestBody Bill bill) {
        return billService.saveBill(bill);
    }


    @GetMapping("/bill")
    public List<Bill> getAllBill(){
        return billService.getAll();
    }

    @GetMapping("/bill/{id}")
    public Optional<Bill> getBillById(@PathVariable("id") int id){
        return billService.getById(id);
    }

    @DeleteMapping("/bill/{id}")
    public void deleteBillById(@PathVariable int id) {
        billService.deleteById(id);
    }


    //PROCEDURES


    @GetMapping("/billsMY/{iyear}/{imonth}")
    public List<Bill> getBillsByMonthAndYear(@PathVariable("iyear") String iyear, @PathVariable("imonth") String imonth) {
        return billService.billsByMonthAndYear(iyear,imonth);
    }

    @GetMapping("/billsAC/{iarea}/{icity}")
    public List<Bill>  billsByCityAndArea(@PathVariable("iarea") String iarea, @PathVariable("icity") String icity) {
        return  billService.billsByCityAndArea(iarea, icity);

    }

    @PutMapping("/bill/{inputId}/{currentReading}")
    public int billsGeneratedByConnectionId(@PathVariable("inputId") int inputId,@PathVariable("currentReading") int currentReading) {
        return billService.generateBillByConnectionId(inputId, currentReading);
    }




    //api to get bill of all consumers //procedure
    @GetMapping("/billAll")
    public List<Bill> getAllBills() {
        return billService.billsOfAllConsumers();

    }




}
