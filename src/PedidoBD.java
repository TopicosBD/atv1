
import java.util.List;
import java.util.Iterator;
import tebd_atividade_1.entity.Pedido;
import tebd_atividade_1.entity.Item;
import tebd_atividade_1.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class PedidoBD extends tebd_atividade_1.util.HibernateUtil {

    public void AdicionarItemBD(Item item_, Pedido pedido_) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        item_.setPedido(pedido_);  
        session.beginTransaction();
        session.save(item_);
        session.getTransaction().commit();
        session.flush();
        session.close();
    }
    
    public void AdicionarPedidoBD(Pedido pedido) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();  
        session.save(pedido);
        session.getTransaction().commit();
        session.flush();
        session.close();
    }

    public void RemoverPedidoBD(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            Pedido pedido = (Pedido) session.load(Pedido.class, id);
            if (null != pedido) {
                session.delete(pedido);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();

        session.flush();
        session.close();
    }
    
    public Pedido ConsultarPedidoBD(int pedidoId){
        Session session = null;
        Pedido pedido = null;
        List<Item> DaoAllItem = null;
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            pedido = (Pedido) session.load(Pedido.class, pedidoId);
            DaoAllItem = session.createCriteria(Item.class).add(Restrictions.eq("pedido.id", pedidoId)).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Iterator<Item> itens = DaoAllItem.iterator();
        while (itens.hasNext()) {
            Item item = itens.next();
            pedido.addItem(item.getDescricao(), item.getQuantidade(), item.getValorUnitario());
        }

        session.flush();
        session.close();
        return pedido;
    }
    
    /*
    Atualizar
    public void updatePedido(Pedido pedido) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        //Pedido pedido = (Pedido) session.load(Pedido.class, id);  
        try {
            if (pedido != null) {
                session.saveOrUpdate(pedido);
            }

        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        session.flush();
        session.close();
    }
    */
    /*
    Consultar ID
    public int getPedidoId() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        String query = "SELECT max(c.id) FROM Pedido c";
        List list = session.createQuery(query).list();
        int maxId = ((Integer) list.get(0));

        trans.commit();
        session.close();
        return (maxId + 1);
    }
    */
    /*
    Listagem de pedidos
    public List<Pedido> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Pedido> DaoAllPedido = null;
        session.beginTransaction();
        try {

            DaoAllPedido = session.createCriteria(Pedido.class).list();
            //DaoAllPedido = (List<Pedido>)session.createQuery("from Pedido").list();  
            int count = DaoAllPedido.size();
            System.out.println("No of Record From Dao: " + count);
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        session.flush();
        session.close();
        return DaoAllPedido;
    }
    */

}
