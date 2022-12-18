package com.example.EMSystem.ServiceImpl;

import com.example.EMSystem.Exception.ResourceNotFoundException;
import com.example.EMSystem.Service.BillService;
import com.example.EMSystem.entity.Bill;
import com.example.EMSystem.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;
import java.util.Optional;

@Service
public class BillServiceImpl  implements BillService {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    @PersistenceContext
    private EntityManager em;

    @Override
    public Bill saveBill(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public List<Bill> getAll() {
        return (List<Bill>) billRepository.findAll();
    }

    @Override
    public Optional<Bill> getById(Integer id) {
        return billRepository.findById(id);
    }

    @Override
    public Bill update(Bill bill, Integer id) throws ResourceNotFoundException {
        Bill b = billRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Bill", "Id", id));
        b.setNewReading(bill.getNewReading());
       // b.setBilledUnits(bill.getBilledUnits());
        billRepository.save(b);
        return b;
    }

    @Override
    public void deleteById(Integer id) {
        billRepository.deleteById(id);

    }



    @SuppressWarnings("unchecked")
    @Override
    public List<Bill> billsOfAllConsumers() {
        StoredProcedureQuery allBills =
                em.createNamedStoredProcedureQuery("billsOfAllConsumers");
        return allBills.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Bill> billsByMonthAndYear(String iyear, String imonth) {
        // TODO Auto-generated method stub
        StoredProcedureQuery billByYear=em.createNamedStoredProcedureQuery("billsByMonthAndYear")
                .setParameter("iyear", iyear).setParameter("imonth", imonth);
        return billByYear.getResultList();
    }

    @Override
    public int generateBillByConnectionId(int inputId, int currentReading) {
        StoredProcedureQuery billById = em.createNamedStoredProcedureQuery("generateBillByConnectionId");
        billById.setParameter("inputId",inputId);
          billById.setParameter("currentReading",currentReading);
        return billById.getUpdateCount();


    }

    @Override
    public List<Bill> billsByCityAndArea(String iarea, String icity) {
        StoredProcedureQuery billByArea = em.createNamedStoredProcedureQuery("billsByCityAndArea")
                .setParameter("iarea", iarea).setParameter("icity", icity);
        return billByArea.getResultList();
    }
}
