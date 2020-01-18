package com.example.demo.entidades;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
    long idUsuariop;

    
    @Column(name="id_consulta")
    long idConsultap;

    
    @Column(name="id_tecnico")
    long idTecnicop;

    @Column(name="id_chat")
    long idChatp;




    @Column(name="monto")
    long monto;
    
    
    /**
     * @return the descripcion
     */
        public Paga(){
            
        }
        public Paga(long id, long idUsuario, long idConsulta, long idTecnico,long monto,long idChat){
            this.id=id;
            this.idUsuariop=idUsuario;
            this.idConsultap=idConsulta;
            this.idTecnicop=idTecnico;
            this.monto=monto;
            this.idChatp=idChat;
        }
        public long getId() {
            return this.id;
        }
        public void setId(long id) {
            this.id = id;
        }
        public long getIdUsuariop() {
            return this.idUsuariop;
        }
        public void setIdUsuariop(long idUsuario) {
            this.idUsuariop = idUsuario;
        }
        public long getIdConsultap() {
            return this.idConsultap;
        }
        public void setIdConsultap(long idConsulta) {
            this.idConsultap = idConsulta;
        }
        public long getIdTecnicop() {
            return this.idTecnicop;
        }
        public void setIdTecnicop(long idTecnico) {
            this.idTecnicop = idTecnico;
        } 
        public long getMonto() {
            return this.monto;
        }
        public void setMonto(long monto) {
            this.monto = monto;
        }
        public long getIdChatp() {
            return this.idChatp;
        }
        public void setIdChatp(long idChat) {
            this.idChatp = idChat;
        }
        
}


