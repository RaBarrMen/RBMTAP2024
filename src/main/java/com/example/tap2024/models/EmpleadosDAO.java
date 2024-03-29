package com.example.tap2024.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.Statement;

public class EmpleadosDAO {
    private int id_empleado;
    private String nombre_empleado;
    private String rfc_empleado;
    private Float salario;
    private String telefono;
    private String direccion;

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getRfc_empleado() {
        return rfc_empleado;
    }

    public void setRfc_empleado(String rfc_empleado) {
        this.rfc_empleado = rfc_empleado;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void INSERTAR(){
        String query = "insert into empleado(nombre_empleado,"+
                "rfc_empleado, salario, telefono, direccion)"+
                "values('"+nombre_empleado+"', '"+rfc_empleado+"',"+salario+" ,'"+telefono+"', '"+direccion+"')";
        try {
            Statement stm = Conexion.connection.createStatement();
            stm.executeUpdate(query);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void ACTUALIZAR(){
        String query = "update empleado set nombre_empleado='"+nombre_empleado+"',"+
                "rfc_empleado='"+rfc_empleado+"', salario="+salario+","+
                "telefono='"+telefono+"', direccion='"+direccion+"' "+
                "where id_empleado = "+id_empleado;
        try {
            Statement stm = Conexion.connection.createStatement();
            stm.executeUpdate(query);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void ELIMINAR(){
        String query = "delete from empleado where id_empleado ="+id_empleado;
        try{
            Statement stmt = Conexion.connection.createStatement();
            stmt.executeUpdate(query);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public ObservableList<EmpleadosDAO> CONSULTAR(){
        ObservableList<EmpleadosDAO> listaemp = FXCollections.observableArrayList();
        String query = "Select * from empleado";

        try{
            EmpleadosDAO objeto_empleado;
            Statement stmt = Conexion.connection.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()){
                objeto_empleado = new EmpleadosDAO();
                objeto_empleado.id_empleado = res.getInt("id_empleado");
                objeto_empleado.nombre_empleado = res.getString("nombre_empleado");
                objeto_empleado.rfc_empleado = res.getString("rfc_empleado");
                objeto_empleado.salario = res.getFloat("salario");
                objeto_empleado.telefono = res.getString("telefono");
                objeto_empleado.direccion = res.getString("direccion");
                listaemp.add(objeto_empleado);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return listaemp;
    }

}
