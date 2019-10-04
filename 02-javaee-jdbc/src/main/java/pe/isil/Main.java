package pe.isil;


import pe.isil.dao.AccountDao;

public class Main {

    public static void main(String[] args) {

        AccountDao accountDao = new AccountDao();
        boolean transferSuccess = accountDao.transfer(1, 2, 1000.00);
        System.out.println("transferSuccess = " + transferSuccess);

    }

}
