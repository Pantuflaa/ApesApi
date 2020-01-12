package com.example.demo.Entidades;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.hibernate.annotations.GenericGenerator;


@Table(name="PAGA")
@Entity
public class Paga {
    @Id
    @GenericGenerator(name="incrementpaga", strategy="increment")
    @GeneratedValue(generator="incrementpaga")
    @Column(name="id_paga")
    long id;
    
    
    @Column(name="id_usuario")
    long idUsuario;

    
    @Column(name="id_consulta")
    long idConsulta;

    
    @Column(name="id_tecnico")
    long idTecnico;

    @Column(name="id_chat")
    long idChat;




    @Column(name="monto")
    long monto;
    
    
    /**
     * @return the descripcion
     */
        public Paga(){
            
        }
        public Paga(long id, long idUsuario, long idConsulta, long idTecnico,long monto,long idChat){
            this.id=id;
            this.idUsuario=idUsuario;
            this.idConsulta=idConsulta;
            this.idTecnico=idTecnico;
            this.monto=monto;
            this.idChat=idChat;
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
        public void setIdUsuario(long idUsuario) {
            this.idUsuario = idUsuario;
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
        public long getMonto() {
            return this.monto;
        }
        public void setMonto(long monto) {
            this.monto = monto;
        }
        public long getIdChat() {
            return this.idChat;
        }
        public void setIdChat(long idChat) {
            this.idChat = idChat;
        }
        
}


