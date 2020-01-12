
create table public.usuario(
    id_usuario serial not null,
    nombre varchar(100) not null,
    pass varchar(100) not null,
    correo varchar(256) not null,
    primary key (id_usuario)
);

create table public.consulta(
    id_consulta serial not null,
    titulo varchar(100) not null,
    descripcion text,
    id_usuario bigint,
    categoria varchar(256),
    fecha varchar(256),
    estado varchar(256),
    primary key (id_consulta),
    foreign key (id_usuario) references usuario(id_usuario)
);
create table public.tecnico(
    id_tecnico serial not null,
    nombre varchar(100) not null,
    pass varchar(100) not null,
    correo varchar(256) not null,
    primary key (id_tecnico)
);


create table public.chat(
    id_chat serial not null,
   	id_usuario bigint,
	id_consulta bigint,
	id_tecnico bigint,
    state bigint,
    primary key (id_chat),
	foreign key (id_usuario) references usuario(id_usuario),
	foreign key (id_tecnico) references tecnico(id_tecnico),
	foreign key (id_consulta) references consulta(id_consulta)
);

create table public.paga(
    id_paga serial not null,
    id_chat bigint,
   	id_usuario bigint,
	id_consulta bigint,
	id_tecnico bigint,
    monto bigint,
    primary key (id_paga),
    foreign key (id_chat) references chat(id_chat),
	foreign key (id_usuario) references usuario(id_usuario),
	foreign key (id_tecnico) references tecnico(id_tecnico),
	foreign key (id_consulta) references consulta(id_consulta)
);

create table public.mensaje(
    id_mensaje serial not null,
    id_chat bigint not null,
    mensaje text not null,
    emisor integer not null,
    primary key (id_mensaje),
	foreign key (id_chat) references chat(id_chat)
);
create table public.feedback(
    id_feed serial not null,
    id_tecnico bigint not null,
    id_usuario bigint not null,
    id_consulta bigint not null,
	comentario text not null,
	rating int not null,
    primary key (id_feed),
	foreign key (id_tecnico) references tecnico(id_tecnico),
	foreign key (id_usuario) references usuario(id_usuario),
	foreign key (id_consulta) references consulta(id_consulta)
);




