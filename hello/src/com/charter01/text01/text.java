package com.charter01.text01;

public class text {
    public void showEmpAnnal(Employee e){
        System.out.println(e.getAnnual());
    }

    public void testWork(Employee e){
        if(e instanceof ordStaff){
            ((ordStaff)e).work();
        }
        else if (e instanceof Manager) {
            ((Manager)e).manage();
        }
    }

}
