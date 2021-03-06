toc.dat                                                                                             0000600 0004000 0002000 00000041210 14061642000 0014426 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        PGDMP       0    8                y         	   ecommerce    13.3    13.3 8    ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false         ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false         ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false         ?           1262    17159 	   ecommerce    DATABASE     i   CREATE DATABASE ecommerce WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE ecommerce;
                postgres    false                     2615    17160    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                postgres    false         ?           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                   postgres    false    5         ?            1259    17161 	   categoria    TABLE     ?   CREATE TABLE public.categoria (
    categoria_id integer NOT NULL,
    nome_categoria character varying(50) NOT NULL,
    descricao_categoria text NOT NULL
);
    DROP TABLE public.categoria;
       public         heap    postgres    false    5         ?            1259    17167    categoria_categoria_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.categoria_categoria_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.categoria_categoria_id_seq;
       public          postgres    false    5    200         ?           0    0    categoria_categoria_id_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.categoria_categoria_id_seq OWNED BY public.categoria.categoria_id;
          public          postgres    false    201         ?            1259    17169    cliente    TABLE     ?  CREATE TABLE public.cliente (
    cliente_id integer NOT NULL,
    email character varying(100) NOT NULL,
    username character varying(50) NOT NULL,
    senha character varying(20) NOT NULL,
    nome_cliente character varying(50) NOT NULL,
    cpf character varying(11) NOT NULL,
    telefone character varying(20) NOT NULL,
    data_nascimento date NOT NULL,
    endereco_id integer
);
    DROP TABLE public.cliente;
       public         heap    postgres    false    5         ?            1259    17172    cliente_cliente_id_seq    SEQUENCE        CREATE SEQUENCE public.cliente_cliente_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.cliente_cliente_id_seq;
       public          postgres    false    5    202         ?           0    0    cliente_cliente_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.cliente_cliente_id_seq OWNED BY public.cliente.cliente_id;
          public          postgres    false    203         ?            1259    17174    endereco    TABLE     b  CREATE TABLE public.endereco (
    endereco_id integer NOT NULL,
    cep character varying(9) NOT NULL,
    rua character varying(100) NOT NULL,
    bairro character varying(50) NOT NULL,
    cidade character varying(50) NOT NULL,
    numero integer NOT NULL,
    complemento character varying(100) NOT NULL,
    estado character varying(50) NOT NULL
);
    DROP TABLE public.endereco;
       public         heap    postgres    false    5         ?            1259    17177    endereco_endereco_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.endereco_endereco_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.endereco_endereco_id_seq;
       public          postgres    false    204    5         ?           0    0    endereco_endereco_id_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.endereco_endereco_id_seq OWNED BY public.endereco.endereco_id;
          public          postgres    false    205         ?            1259    17179    pedido    TABLE     =  CREATE TABLE public.pedido (
    pedido_id integer NOT NULL,
    numero_pedido integer NOT NULL,
    lista_de_produtos_do_pedido character varying NOT NULL,
    valor_total_pedido numeric NOT NULL,
    data_pedido date DEFAULT now() NOT NULL,
    status character varying NOT NULL,
    cliente_id integer NOT NULL
);
    DROP TABLE public.pedido;
       public         heap    postgres    false    5         ?            1259    17186    pedido_pedido_id_seq    SEQUENCE     }   CREATE SEQUENCE public.pedido_pedido_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.pedido_pedido_id_seq;
       public          postgres    false    5    206         ?           0    0    pedido_pedido_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.pedido_pedido_id_seq OWNED BY public.pedido.pedido_id;
          public          postgres    false    207         ?            1259    17188    produto    TABLE     5  CREATE TABLE public.produto (
    produto_id integer NOT NULL,
    nome_produto character varying(50) NOT NULL,
    descricao_produto text NOT NULL,
    preco_produto numeric NOT NULL,
    qtd_estoque integer,
    data_cadastro_produto date NOT NULL,
    imagem character varying,
    categoria_id integer
);
    DROP TABLE public.produto;
       public         heap    postgres    false    5         ?            1259    17194    produto_pedido    TABLE     ?   CREATE TABLE public.produto_pedido (
    produto_pedido_id integer NOT NULL,
    produto_id integer NOT NULL,
    pedido_id integer NOT NULL,
    quantidade integer NOT NULL,
    preco numeric NOT NULL
);
 "   DROP TABLE public.produto_pedido;
       public         heap    postgres    false    5         ?            1259    17200 $   produto_pedido_produto_pedido_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.produto_pedido_produto_pedido_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ;   DROP SEQUENCE public.produto_pedido_produto_pedido_id_seq;
       public          postgres    false    209    5         ?           0    0 $   produto_pedido_produto_pedido_id_seq    SEQUENCE OWNED BY     m   ALTER SEQUENCE public.produto_pedido_produto_pedido_id_seq OWNED BY public.produto_pedido.produto_pedido_id;
          public          postgres    false    210         ?            1259    17202    produto_produto_id_seq    SEQUENCE        CREATE SEQUENCE public.produto_produto_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.produto_produto_id_seq;
       public          postgres    false    5    208         ?           0    0    produto_produto_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.produto_produto_id_seq OWNED BY public.produto.produto_id;
          public          postgres    false    211         D           2604    17204    categoria categoria_id    DEFAULT     ?   ALTER TABLE ONLY public.categoria ALTER COLUMN categoria_id SET DEFAULT nextval('public.categoria_categoria_id_seq'::regclass);
 E   ALTER TABLE public.categoria ALTER COLUMN categoria_id DROP DEFAULT;
       public          postgres    false    201    200         E           2604    17205    cliente cliente_id    DEFAULT     x   ALTER TABLE ONLY public.cliente ALTER COLUMN cliente_id SET DEFAULT nextval('public.cliente_cliente_id_seq'::regclass);
 A   ALTER TABLE public.cliente ALTER COLUMN cliente_id DROP DEFAULT;
       public          postgres    false    203    202         F           2604    17206    endereco endereco_id    DEFAULT     |   ALTER TABLE ONLY public.endereco ALTER COLUMN endereco_id SET DEFAULT nextval('public.endereco_endereco_id_seq'::regclass);
 C   ALTER TABLE public.endereco ALTER COLUMN endereco_id DROP DEFAULT;
       public          postgres    false    205    204         H           2604    17207    pedido pedido_id    DEFAULT     t   ALTER TABLE ONLY public.pedido ALTER COLUMN pedido_id SET DEFAULT nextval('public.pedido_pedido_id_seq'::regclass);
 ?   ALTER TABLE public.pedido ALTER COLUMN pedido_id DROP DEFAULT;
       public          postgres    false    207    206         I           2604    17208    produto produto_id    DEFAULT     x   ALTER TABLE ONLY public.produto ALTER COLUMN produto_id SET DEFAULT nextval('public.produto_produto_id_seq'::regclass);
 A   ALTER TABLE public.produto ALTER COLUMN produto_id DROP DEFAULT;
       public          postgres    false    211    208         J           2604    17209     produto_pedido produto_pedido_id    DEFAULT     ?   ALTER TABLE ONLY public.produto_pedido ALTER COLUMN produto_pedido_id SET DEFAULT nextval('public.produto_pedido_produto_pedido_id_seq'::regclass);
 O   ALTER TABLE public.produto_pedido ALTER COLUMN produto_pedido_id DROP DEFAULT;
       public          postgres    false    210    209         ?          0    17161 	   categoria 
   TABLE DATA           V   COPY public.categoria (categoria_id, nome_categoria, descricao_categoria) FROM stdin;
    public          postgres    false    200       3044.dat ?          0    17169    cliente 
   TABLE DATA           ?   COPY public.cliente (cliente_id, email, username, senha, nome_cliente, cpf, telefone, data_nascimento, endereco_id) FROM stdin;
    public          postgres    false    202       3046.dat ?          0    17174    endereco 
   TABLE DATA           f   COPY public.endereco (endereco_id, cep, rua, bairro, cidade, numero, complemento, estado) FROM stdin;
    public          postgres    false    204       3048.dat ?          0    17179    pedido 
   TABLE DATA           ?   COPY public.pedido (pedido_id, numero_pedido, lista_de_produtos_do_pedido, valor_total_pedido, data_pedido, status, cliente_id) FROM stdin;
    public          postgres    false    206       3050.dat ?          0    17188    produto 
   TABLE DATA           ?   COPY public.produto (produto_id, nome_produto, descricao_produto, preco_produto, qtd_estoque, data_cadastro_produto, imagem, categoria_id) FROM stdin;
    public          postgres    false    208       3052.dat ?          0    17194    produto_pedido 
   TABLE DATA           e   COPY public.produto_pedido (produto_pedido_id, produto_id, pedido_id, quantidade, preco) FROM stdin;
    public          postgres    false    209       3053.dat ?           0    0    categoria_categoria_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.categoria_categoria_id_seq', 6, true);
          public          postgres    false    201         ?           0    0    cliente_cliente_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.cliente_cliente_id_seq', 46, true);
          public          postgres    false    203         ?           0    0    endereco_endereco_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.endereco_endereco_id_seq', 26, true);
          public          postgres    false    205                     0    0    pedido_pedido_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.pedido_pedido_id_seq', 6, true);
          public          postgres    false    207                    0    0 $   produto_pedido_produto_pedido_id_seq    SEQUENCE SET     S   SELECT pg_catalog.setval('public.produto_pedido_produto_pedido_id_seq', 1, false);
          public          postgres    false    210                    0    0    produto_produto_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.produto_produto_id_seq', 13, true);
          public          postgres    false    211         L           2606    17211    categoria categoria_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.categoria
    ADD CONSTRAINT categoria_pkey PRIMARY KEY (categoria_id);
 B   ALTER TABLE ONLY public.categoria DROP CONSTRAINT categoria_pkey;
       public            postgres    false    200         N           2606    17213    cliente cliente_cpf_key 
   CONSTRAINT     Q   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_cpf_key UNIQUE (cpf);
 A   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_cpf_key;
       public            postgres    false    202         P           2606    17215    cliente cliente_email_key 
   CONSTRAINT     U   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_email_key UNIQUE (email);
 C   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_email_key;
       public            postgres    false    202         R           2606    17217    cliente cliente_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (cliente_id);
 >   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_pkey;
       public            postgres    false    202         T           2606    17219    cliente cliente_username_key 
   CONSTRAINT     [   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_username_key UNIQUE (username);
 F   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_username_key;
       public            postgres    false    202         V           2606    17221    endereco endereco_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.endereco
    ADD CONSTRAINT endereco_pkey PRIMARY KEY (endereco_id);
 @   ALTER TABLE ONLY public.endereco DROP CONSTRAINT endereco_pkey;
       public            postgres    false    204         X           2606    17223    pedido pedido_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.pedido
    ADD CONSTRAINT pedido_pkey PRIMARY KEY (pedido_id);
 <   ALTER TABLE ONLY public.pedido DROP CONSTRAINT pedido_pkey;
       public            postgres    false    206         \           2606    17225 "   produto_pedido produto_pedido_pkey 
   CONSTRAINT     o   ALTER TABLE ONLY public.produto_pedido
    ADD CONSTRAINT produto_pedido_pkey PRIMARY KEY (produto_pedido_id);
 L   ALTER TABLE ONLY public.produto_pedido DROP CONSTRAINT produto_pedido_pkey;
       public            postgres    false    209         Z           2606    17227    produto produto_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.produto
    ADD CONSTRAINT produto_pkey PRIMARY KEY (produto_id);
 >   ALTER TABLE ONLY public.produto DROP CONSTRAINT produto_pkey;
       public            postgres    false    208         _           2606    17228    produto categoria_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.produto
    ADD CONSTRAINT categoria_fkey FOREIGN KEY (categoria_id) REFERENCES public.categoria(categoria_id);
 @   ALTER TABLE ONLY public.produto DROP CONSTRAINT categoria_fkey;
       public          postgres    false    200    2892    208         ^           2606    17233    pedido cliente_fkey    FK CONSTRAINT        ALTER TABLE ONLY public.pedido
    ADD CONSTRAINT cliente_fkey FOREIGN KEY (cliente_id) REFERENCES public.cliente(cliente_id);
 =   ALTER TABLE ONLY public.pedido DROP CONSTRAINT cliente_fkey;
       public          postgres    false    2898    206    202         ]           2606    17238    cliente endereco_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT endereco_fkey FOREIGN KEY (endereco_id) REFERENCES public.endereco(endereco_id);
 ?   ALTER TABLE ONLY public.cliente DROP CONSTRAINT endereco_fkey;
       public          postgres    false    2902    202    204         `           2606    17243    produto_pedido pedido_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.produto_pedido
    ADD CONSTRAINT pedido_fkey FOREIGN KEY (pedido_id) REFERENCES public.pedido(pedido_id);
 D   ALTER TABLE ONLY public.produto_pedido DROP CONSTRAINT pedido_fkey;
       public          postgres    false    206    209    2904         a           2606    17248    produto_pedido produto_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.produto_pedido
    ADD CONSTRAINT produto_fkey FOREIGN KEY (produto_id) REFERENCES public.produto(produto_id);
 E   ALTER TABLE ONLY public.produto_pedido DROP CONSTRAINT produto_fkey;
       public          postgres    false    208    2906    209                                                                                                                                                                                                                                                                                                                                                                                                3044.dat                                                                                            0000600 0004000 0002000 00000000301 14061642000 0014227 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	 videogame 	 consoles, acessorios e jogos 
2	 bebidas 	 vinho, cerveja, refrigerante, uísque, vodka 
5	 automotivo 	 oficina, pneus e fluidos 
3	 pet shop 	 racao, brinquedos e roupas 
\.


                                                                                                                                                                                                                                                                                                                               3046.dat                                                                                            0000600 0004000 0002000 00000001332 14061642000 0014236 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        10	lucio25@gmail.com	lucio25	90909090	Lucimar Macedo	13515795216	24988547687	1978-05-23	1
11	ladisVal@gmail.com	ladisVal	89898989	Valdemar Ladislau	12266654898	2165789829	1932-06-24	2
12	robertinho@gmail.com	robertinho	56765678	Roberto	13256789122	24981726357	2002-04-28	3
13	femonomeno9@gmail.com	femonomeno	jisajiodjwek	Ronaldo Nazario	19942002062	24988653727	1976-09-22	2
14	pelé10@gmail.com	pelé	dretdjds	Edison Arantes	19701346420	2499887687	1948-10-23	3
15	julioRica@gmail.com	julioRica	2134355hf	Julio	13515765789	24988549999	1954-01-22	2
16	JaiminFadi@gmail.com	JaiminFadi	dkkiji231	Jaime Costa	56798742336	24992547457	1945-06-25	1
17	zezinho5@gmail.com	zezinho	5142635799	Jose	14747355987	24988969587	1984-10-09	1
\.


                                                                                                                                                                                                                                                                                                      3048.dat                                                                                            0000600 0004000 0002000 00000000263 14061642000 0014242 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	25675160	Rua Bataillard	Mosela	Petrópolis	1179	A	RJ
2	30620690	Rua Mosela	Milionários	Belo Horizonte	153	A	MG
3	25640020	Avenida Dom Pedro I	Centro	Petrópolis	1650	A	RJ
\.


                                                                                                                                                                                                                                                                                                                                             3050.dat                                                                                            0000600 0004000 0002000 00000000173 14061642000 0014233 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        2	2	osso	20	2021-06-11	não-finalizado	11
6	3	teste	10	2021-06-11	finalizado	10
1	1	vodka	10	2021-06-11	finalizado	10
\.


                                                                                                                                                                                                                                                                                                                                                                                                     3052.dat                                                                                            0000600 0004000 0002000 00000001602 14061642000 0014233 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        2	 pneu careca 	 Peneu de fusca, já no arame. Ótimo pra fazer um chinelo 	150	10	2014-06-25	\\x6e756c6c	5
3	 Vodka 	 Pioneira na categoria de Vodka, sendo a principal referência no mundo 	7	600	2020-12-30	\\x6e756c6c	2
4	 Osso Roído 	 Osso roído por, nada mais nada menos que um vira lata caramelo. Item extremamente valioso 	5	1	1980-04-10	\\x6e756c6c	3
5	 Oficina 	 O Jogo oficina mestre 5000R possui AMPLO misturar de Chaves, soquetes e Acessórios, Diversos Perfis Essenciais para o dia-a-dia 	10000	1	2021-02-22	\\x6e756c6c	5
6	 Vinho 	 Tinto Seco 	10	2580	2021-03-28	\\x6e756c6c	2
7	 Playstation5 	 Console de jogos eletrônicos de nona geração e sucessor do PlayStation 4, desenvolvido pela Sony Interactive Entertainment 	5000	4	2020-10-01	\\x	1
8	 Vinho Tinto 	 Vinho top. Tão bom que bebi Metade 	246	10	1999-05-23	\\x	2
1	 Coleira 	 Coleiras Pequenas	10	57	2020-01-15	\\x	3
\.


                                                                                                                              3053.dat                                                                                            0000600 0004000 0002000 00000000005 14061642000 0014230 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        \.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           restore.sql                                                                                         0000600 0004000 0002000 00000033344 14061642000 0015364 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        --
-- NOTE:
--
-- File paths need to be edited. Search for $$PATH$$ and
-- replace it with the path to the directory containing
-- the extracted data files.
--
--
-- PostgreSQL database dump
--

-- Dumped from database version 13.3
-- Dumped by pg_dump version 13.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE ecommerce;
--
-- Name: ecommerce; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE ecommerce WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Portuguese_Brazil.1252';


ALTER DATABASE ecommerce OWNER TO postgres;

\connect ecommerce

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: categoria; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categoria (
    categoria_id integer NOT NULL,
    nome_categoria character varying(50) NOT NULL,
    descricao_categoria text NOT NULL
);


ALTER TABLE public.categoria OWNER TO postgres;

--
-- Name: categoria_categoria_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.categoria_categoria_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.categoria_categoria_id_seq OWNER TO postgres;

--
-- Name: categoria_categoria_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.categoria_categoria_id_seq OWNED BY public.categoria.categoria_id;


--
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cliente (
    cliente_id integer NOT NULL,
    email character varying(100) NOT NULL,
    username character varying(50) NOT NULL,
    senha character varying(20) NOT NULL,
    nome_cliente character varying(50) NOT NULL,
    cpf character varying(11) NOT NULL,
    telefone character varying(20) NOT NULL,
    data_nascimento date NOT NULL,
    endereco_id integer
);


ALTER TABLE public.cliente OWNER TO postgres;

--
-- Name: cliente_cliente_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cliente_cliente_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cliente_cliente_id_seq OWNER TO postgres;

--
-- Name: cliente_cliente_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cliente_cliente_id_seq OWNED BY public.cliente.cliente_id;


--
-- Name: endereco; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.endereco (
    endereco_id integer NOT NULL,
    cep character varying(9) NOT NULL,
    rua character varying(100) NOT NULL,
    bairro character varying(50) NOT NULL,
    cidade character varying(50) NOT NULL,
    numero integer NOT NULL,
    complemento character varying(100) NOT NULL,
    estado character varying(50) NOT NULL
);


ALTER TABLE public.endereco OWNER TO postgres;

--
-- Name: endereco_endereco_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.endereco_endereco_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.endereco_endereco_id_seq OWNER TO postgres;

--
-- Name: endereco_endereco_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.endereco_endereco_id_seq OWNED BY public.endereco.endereco_id;


--
-- Name: pedido; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pedido (
    pedido_id integer NOT NULL,
    numero_pedido integer NOT NULL,
    lista_de_produtos_do_pedido character varying NOT NULL,
    valor_total_pedido numeric NOT NULL,
    data_pedido date DEFAULT now() NOT NULL,
    status character varying NOT NULL,
    cliente_id integer NOT NULL
);


ALTER TABLE public.pedido OWNER TO postgres;

--
-- Name: pedido_pedido_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pedido_pedido_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pedido_pedido_id_seq OWNER TO postgres;

--
-- Name: pedido_pedido_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pedido_pedido_id_seq OWNED BY public.pedido.pedido_id;


--
-- Name: produto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.produto (
    produto_id integer NOT NULL,
    nome_produto character varying(50) NOT NULL,
    descricao_produto text NOT NULL,
    preco_produto numeric NOT NULL,
    qtd_estoque integer,
    data_cadastro_produto date NOT NULL,
    imagem character varying,
    categoria_id integer
);


ALTER TABLE public.produto OWNER TO postgres;

--
-- Name: produto_pedido; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.produto_pedido (
    produto_pedido_id integer NOT NULL,
    produto_id integer NOT NULL,
    pedido_id integer NOT NULL,
    quantidade integer NOT NULL,
    preco numeric NOT NULL
);


ALTER TABLE public.produto_pedido OWNER TO postgres;

--
-- Name: produto_pedido_produto_pedido_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.produto_pedido_produto_pedido_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.produto_pedido_produto_pedido_id_seq OWNER TO postgres;

--
-- Name: produto_pedido_produto_pedido_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.produto_pedido_produto_pedido_id_seq OWNED BY public.produto_pedido.produto_pedido_id;


--
-- Name: produto_produto_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.produto_produto_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.produto_produto_id_seq OWNER TO postgres;

--
-- Name: produto_produto_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.produto_produto_id_seq OWNED BY public.produto.produto_id;


--
-- Name: categoria categoria_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categoria ALTER COLUMN categoria_id SET DEFAULT nextval('public.categoria_categoria_id_seq'::regclass);


--
-- Name: cliente cliente_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente ALTER COLUMN cliente_id SET DEFAULT nextval('public.cliente_cliente_id_seq'::regclass);


--
-- Name: endereco endereco_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endereco ALTER COLUMN endereco_id SET DEFAULT nextval('public.endereco_endereco_id_seq'::regclass);


--
-- Name: pedido pedido_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido ALTER COLUMN pedido_id SET DEFAULT nextval('public.pedido_pedido_id_seq'::regclass);


--
-- Name: produto produto_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto ALTER COLUMN produto_id SET DEFAULT nextval('public.produto_produto_id_seq'::regclass);


--
-- Name: produto_pedido produto_pedido_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto_pedido ALTER COLUMN produto_pedido_id SET DEFAULT nextval('public.produto_pedido_produto_pedido_id_seq'::regclass);


--
-- Data for Name: categoria; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.categoria (categoria_id, nome_categoria, descricao_categoria) FROM stdin;
\.
COPY public.categoria (categoria_id, nome_categoria, descricao_categoria) FROM '$$PATH$$/3044.dat';

--
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cliente (cliente_id, email, username, senha, nome_cliente, cpf, telefone, data_nascimento, endereco_id) FROM stdin;
\.
COPY public.cliente (cliente_id, email, username, senha, nome_cliente, cpf, telefone, data_nascimento, endereco_id) FROM '$$PATH$$/3046.dat';

--
-- Data for Name: endereco; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.endereco (endereco_id, cep, rua, bairro, cidade, numero, complemento, estado) FROM stdin;
\.
COPY public.endereco (endereco_id, cep, rua, bairro, cidade, numero, complemento, estado) FROM '$$PATH$$/3048.dat';

--
-- Data for Name: pedido; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pedido (pedido_id, numero_pedido, lista_de_produtos_do_pedido, valor_total_pedido, data_pedido, status, cliente_id) FROM stdin;
\.
COPY public.pedido (pedido_id, numero_pedido, lista_de_produtos_do_pedido, valor_total_pedido, data_pedido, status, cliente_id) FROM '$$PATH$$/3050.dat';

--
-- Data for Name: produto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.produto (produto_id, nome_produto, descricao_produto, preco_produto, qtd_estoque, data_cadastro_produto, imagem, categoria_id) FROM stdin;
\.
COPY public.produto (produto_id, nome_produto, descricao_produto, preco_produto, qtd_estoque, data_cadastro_produto, imagem, categoria_id) FROM '$$PATH$$/3052.dat';

--
-- Data for Name: produto_pedido; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.produto_pedido (produto_pedido_id, produto_id, pedido_id, quantidade, preco) FROM stdin;
\.
COPY public.produto_pedido (produto_pedido_id, produto_id, pedido_id, quantidade, preco) FROM '$$PATH$$/3053.dat';

--
-- Name: categoria_categoria_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.categoria_categoria_id_seq', 6, true);


--
-- Name: cliente_cliente_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cliente_cliente_id_seq', 46, true);


--
-- Name: endereco_endereco_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.endereco_endereco_id_seq', 26, true);


--
-- Name: pedido_pedido_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pedido_pedido_id_seq', 6, true);


--
-- Name: produto_pedido_produto_pedido_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.produto_pedido_produto_pedido_id_seq', 1, false);


--
-- Name: produto_produto_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.produto_produto_id_seq', 13, true);


--
-- Name: categoria categoria_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categoria
    ADD CONSTRAINT categoria_pkey PRIMARY KEY (categoria_id);


--
-- Name: cliente cliente_cpf_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_cpf_key UNIQUE (cpf);


--
-- Name: cliente cliente_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_email_key UNIQUE (email);


--
-- Name: cliente cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (cliente_id);


--
-- Name: cliente cliente_username_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_username_key UNIQUE (username);


--
-- Name: endereco endereco_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endereco
    ADD CONSTRAINT endereco_pkey PRIMARY KEY (endereco_id);


--
-- Name: pedido pedido_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido
    ADD CONSTRAINT pedido_pkey PRIMARY KEY (pedido_id);


--
-- Name: produto_pedido produto_pedido_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto_pedido
    ADD CONSTRAINT produto_pedido_pkey PRIMARY KEY (produto_pedido_id);


--
-- Name: produto produto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto
    ADD CONSTRAINT produto_pkey PRIMARY KEY (produto_id);


--
-- Name: produto categoria_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto
    ADD CONSTRAINT categoria_fkey FOREIGN KEY (categoria_id) REFERENCES public.categoria(categoria_id);


--
-- Name: pedido cliente_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido
    ADD CONSTRAINT cliente_fkey FOREIGN KEY (cliente_id) REFERENCES public.cliente(cliente_id);


--
-- Name: cliente endereco_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT endereco_fkey FOREIGN KEY (endereco_id) REFERENCES public.endereco(endereco_id);


--
-- Name: produto_pedido pedido_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto_pedido
    ADD CONSTRAINT pedido_fkey FOREIGN KEY (pedido_id) REFERENCES public.pedido(pedido_id);


--
-- Name: produto_pedido produto_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto_pedido
    ADD CONSTRAINT produto_fkey FOREIGN KEY (produto_id) REFERENCES public.produto(produto_id);


--
-- PostgreSQL database dump complete
--

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            