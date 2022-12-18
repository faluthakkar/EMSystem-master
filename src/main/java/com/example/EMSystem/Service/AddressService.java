package com.example.EMSystem.Service;

import com.example.EMSystem.Exception.ResourceAlreadyExits;
import com.example.EMSystem.Exception.ResourceNotFoundException;
import com.example.EMSystem.entity.Address;
import javax.transaction.Transactional;
import java.util.List;

public interface AddressService {
    Address saveAddress(Address address) throws  ResourceAlreadyExits;
    List<Address> getAll();
    void deleteAddressById(int id);
    @Transactional
    Address updateAddress(Address address,int id) throws ResourceNotFoundException;
}
