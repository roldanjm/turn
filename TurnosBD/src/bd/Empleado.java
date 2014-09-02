/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

/**
 *
 * @author Diego
 */
public class Empleado {
    Integer emp_id            = 0;
    String  emp_nombre        = "";
    String  emp_apellido      = "";
    Integer usu_id            = 0;
    String  emp_telefono      = "";
    String  emp_celular       = "";
    Integer tidodoc_id        = 0;
    String  emp_nrodoc        = "";
    String  emp_direccion     = "";
    String  emp_sector        = "";
    String  emp_observaciones = "";
    
public Integer getEmp_id  (){
    return this.emp_id;
}
public String getEmp_nombre(){
    return this.emp_nombre;
}
public String getEmp_apellido() {
    return this.emp_apellido;
}
public Integer getUsu_id  (){
    return this.usu_id;
}
public String getEmp_telefono() {
    return this.emp_telefono;
}
public String getEmp_celular(){
    return this.emp_celular;
}
public Integer getTidodoc_id (){
    return this.tidodoc_id;
}
public String getEmp_nrodoc(){
    return this.emp_nrodoc;
}
public String getEmp_direccion(){
    return this.emp_direccion;
}
public String getEmp_sector(){
    return this.emp_sector;
}
public String getEmp_observaciones (){
    return this.emp_observaciones;
}

/****************  SETTERS ****************/
public Empleado setEmp_id (Integer valor){
 this.emp_id = valor;
 return this; 
}
public Empleado setEmp_nombre (String valor){
    this.emp_nombre = valor;
    return this;
}
public Empleado setEmp_apellido (String valor){
    this.emp_apellido = valor;
    return this;
}
public Empleado setUsu_id (Integer valor){
    this.usu_id          = valor;
    return this;  
}
public Empleado setEmp_telefono (String valor){
    this.emp_telefono = valor;
    return this;
}
public Empleado setEmp_celular (String valor){
    this.emp_celular = valor;
    return this;
}
public Empleado setTidodoc_id (Integer valor){
    this.tidodoc_id      = valor;
    return this;  
}
public Empleado setEmp_nrodoc (String valor){
    this.emp_nrodoc       = valor;
 return this; 
}
public Empleado setEmp_direccion (String valor){
    this.emp_direccion     = valor;
 return this;
}
public Empleado setEmp_sector (String valor){
    this.emp_sector        = valor;
 return this;
}
public Empleado setEmp_observaciones (String valor){
    this.emp_observaciones = valor;
 return this;
}

}
