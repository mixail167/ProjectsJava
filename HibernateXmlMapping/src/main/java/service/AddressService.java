package service;

import bl.SessionUtil;
import dao.AddressDAO;
import entity.Address;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AddressService extends SessionUtil implements AddressDAO {

    public void add(Address address) {
        openTransactionSession();
        Session session = getSession();
        session.save(address);
        closeTransactionSesstion();
    }

    public List<Address> getAll() {

        openTransactionSession();
        String sql = "SELECT * FROM ADDRESS";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Address.class);
        List<Address> addressList = query.list();
        closeTransactionSesstion();
        return addressList;
    }

    public Address getById(Long id) {
        openTransactionSession();
        String sql = "SELECT * FROM ADDRESS WHERE ID = :id";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Address.class);
        query.setParameter("id", id);
        Address address = (Address) query.getSingleResult();
        closeTransactionSesstion();
        return address;
    }

    public void update(Address address) {
        openTransactionSession();
        Session session = getSession();
        session.update(address);
        closeTransactionSesstion();
    }

    public void remove(Address address) {
        openTransactionSession();
        Session session = getSession();
        session.remove(address);
        closeTransactionSesstion();
    }
}
