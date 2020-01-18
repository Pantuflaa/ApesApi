package com.example.demo.entidades;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;


import org.hibernate.annotations.GenericGenerator;


@Table(name="CHAT")
@Entity
public class Chat {
    @Id
    @GenericGenerator(name="incrementchat", strategy="increment")
    @GeneratedValue(generator="incrementchat")
    @Column(name="id_chat")
    long id;
    
    
    @Column(name="id_usuario")
    long idUsuario;

    
    @Column(name="id_consulta")
    long idConsulta;

    
    @Column(name="id_tecnico")
    long idTecnico;

    @Column(name="state")
    long state;
    
    
    /**
     * @return the descripcion
     */
        public Chat(){
            
        }
        public Chat(long id, long idusuario, long idConsulta, long idTecnico,long state){
            this.id=id;
            this.idUsuario=idusuario;
            this.idConsulta=idConsulta;
            this.idTecnico=idTecnico;
            this.state=state;
            
        }
        public long getId() {
            return this.id;
        }
        public void setId(long id) {
            this.id = id;
        }
        public long getIdUsuario() {
            return this.idUsuario;
        }
        public void setIdUsuario(long idusuario) {
            this.idUsuario = idusuario;
        }
        public long getIdConsulta() {
            return this.idConsulta;
        }
        public void setIdConsulta(long idConsulta) {
            this.idConsulta = idConsulta;
        }
        public long getIdTecnico() {
            return this.idTecnico;
        }
        public void setIdTecnico(long idTecnico) {
            this.idTecnico = idTecnico;
        } 
        public long getState() {
            return this.state;
        }
        public void setState(long state) {
            this.state = state;
        }
        
}


