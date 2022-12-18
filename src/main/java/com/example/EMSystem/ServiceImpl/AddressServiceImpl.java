package com.example.EMSystem.ServiceImpl;

import com.example.EMSystem.Exception.ResourceAlreadyExits;
import com.example.EMSystem.Exception.ResourceNotFoundException;
import com.example.EMSystem.Service.AddressService;
import com.example.EMSystem.entity.Address;
import com.example.EMSystem.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;


    @Override
    public Address saveAddress(Address address) throws  ResourceAlreadyExits {
       if(addressRepository.existsById(address.getId())){
           throw  new ResourceAlreadyExits("Address id exits","address",address);
       }
        return addressRepository.save(address);
    }


    @Override
    public List<Address> getAll() {
        // TODO Auto-generated method stub
        return (List<Address>) addressRepository.findAll();
    }


    @Override
    public void deleteAddressById(int id) {
        addressRepository.deleteById(id);
    }


    @Override
    public Address updateAddress(Address address, int id) throws ResourceNotFoundException {
        Address a = addressRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Address by id doesn't exists!!","Id",id));
        a.setArea(address.getArea());
        a.setCity(address.getCity());
        addressRepository.save(a);
        return a;
    }

}
