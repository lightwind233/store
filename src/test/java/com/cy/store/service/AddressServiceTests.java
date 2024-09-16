package com.cy.store.service;

import com.cy.store.entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressServiceTests {
    @Autowired
    private IAddressService addressService;

    @Test
    public void addNewAddress() {
        Address address = new Address();
        address.setPhone("175726");
        address.setName("男朋友4.11");
        addressService.addNewAddress(11,"mxy",address);
    }

    @Test
    public void setDefault() {
        addressService.setDefault(7,11,"管理员");
    }

    @Test
    public void delete() {
        addressService.delete(1,11,"4.11删除");
    }
}
