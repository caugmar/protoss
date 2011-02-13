<html>
<head>
    <meta http-equiv="CONTENT-TYPE" content="text/html; charset=iso-8859-1">
    <title>Recibos de Aluguel</title>
    <style type="text/css">
        @@page { 
            size: a4;
        }
        body {
            font-family: "Times New Roman";
            font-size: 12pt;
            line-height: 2em;
            text-align: justify;
            margin: 0 2cm 2cm 2cm;
        }
        p {
            text-align: justify;
            margin-bottom: 1cm;
        }
        p:first-line {
            margin-left: 2cm;
        }
        h1 {
            font-size: 115%;
            font-weight: bold;
            text-decoration: underline;
            margin-bottom: 1.25cm;
            text-align: left;
            padding-top: 4cm;
        }
        p.data, p.assinatura {
            text-align: right;
            margin-bottom: 2cm;
        }
        p.locador {
            text-align: left;
            page-break-after: always
        }
    </style>
</head>
<body>
@empy.startDiversion("minister")

<h1>RECIBO DE ALUGUEL DE IMÓVEL</h1>

<p>Recebi de MINISTER SERVIÇOS CONTÁBEIS LTDA,
firma estabelecida à Avenida Vereador Benedito de
Campos, n.º 156, Ibiúna, SP, CNPJ n.º
49.313.661/0001-66, a importância líquida de R$
60,00 (sessenta reais), referente ao
aluguel mensal da sala comercial n.° 7 no 2.º
pavimento do imóvel acima, vencido em
@vencimento.</p>

<p>Para maior clareza, firmo o presente.</p>

<p class="data">Ibiúna, @pagamento.</p>

@empy.stopDiverting()
@empy.replayDiversion("minister")

<p class="assinatura">
______________________________ <br />
JOSÉ ANTÔNIO MARCICANO
</p>

<p class="locador">
JOSÉ ANTÔNIO MARCICANO <br />
CIC n.° 238.514.658-49 <br />
Rua Doutor Gabriel Monteiro da Silva, 297 <br />
Centro - Ibiúna - SP
</p>
@empy.replayDiversion("minister")

<p class="assinatura">
______________________________ <br />
ELIZEU MARCICANO
</p>

<p class="locador">
ELIZEU MARCICANO <br />
CIC n.° 038.457.708-30 <br />
Rua Cirineu Soares de Campos, 220 <br />
Centro - Ibiúna - SP
</p>
@empy.replayDiversion("minister")

<p class="assinatura">
______________________________ <br />
CELSO MARCICANO
</p>

<p class="locador">
CELSO MARCICANO <br />
CIC n.° 038.457.458-00 <br />
Rua Benjamin Constant, 245 <br />
Centro - Ibiúna - SP
</p>
@empy.startDiversion("takafuji")

<h1>RECIBO DE ALUGUEL DE IMÓVEL</h1>

<p>Recebi de AGRO COMERCIAL TAKAFUJI LTDA, firma estabelecida à Avenida São
Sebastião, n.º 651, Ibiúna, SP, CNPJ n.º 45.405.651/0001-08, a importância
líquida de R$ 1.400,00 (um mil e quatrocentos reais), referente ao aluguel
mensal de um salão comercial no endereço acima, vencido em @vencimento.</p>

<p>Para maior clareza, firmo o presente.</p>

<p class="data">Ibiúna, @pagamento.</p>

@empy.stopDiverting()
@empy.replayDiversion("takafuji")

<p class="assinatura">
______________________________ <br />
EIJI TAKAFUJI
</p>

<p class="locador">
EIJI TAKAFUJI <br />
CIC n.° 187.029.708-30 <br />
Rua José Eugênio Machado, n.º 595 <br />
Centro - Ibiúna - SP
</p>
@empy.replayDiversion("takafuji")

<p class="assinatura">
________________________________________ <br />
ABIGAIL LUIZA DE MORAES TAKAFUJI
</p>

<p class="locador">
ABIGAIL LUIZA DE MORAES TAKAFUJI <br />
CIC n.° 039.466.688-79 <br />
Rua José Eugênio Machado, n.º 595 <br />
Centro - Ibiúna - SP
</p>
@empy.startDiversion("lbm")

<h1>RECIBO DE ALUGUEL DE IMÓVEL</h1>

<p>Recebi de LBM - ESCRITÓRIO DE SERVIÇOS IBIÚNA
LTDA. - ME, firma estabelecida à Avenida Vereador
Benedito de Campos, n.º 156, 1.º andar, sala 6,
Ibiúna, SP, CNPJ n.º 05.296.042/0001-35, a
importância líquida de R$ 60,00 (sessenta
reais), referente ao aluguel mensal de salas
comerciais no 2.º pavimento do imóvel acima,
vencido em @vencimento.</p>

<p>Para maior clareza, firmo o presente.</p>

<p class="data">Ibiúna, @pagamento.</p>

@empy.stopDiverting()
@empy.replayDiversion("lbm")

<p class="assinatura">
______________________________ <br />

JOSÉ ANTÔNIO MARCICANO
</p>

<p class="locador">
JOSÉ ANTÔNIO MARCICANO <br />
CIC n.° 238.514.658-49 <br />
Rua Doutor Gabriel Monteiro da Silva, 297 <br />
Centro - Ibiúna - SP
</p>
@empy.replayDiversion("lbm")

<p class="assinatura">
______________________________ <br />
ELIZEU MARCICANO
</p>

<p class="locador">
ELIZEU MARCICANO <br />
CIC n.° 038.457.708-30 <br />
Rua Cirineu Soares de Campos, 220 <br />
Centro - Ibiúna - SP
</p>
@empy.replayDiversion("lbm")

<p class="assinatura">
______________________________ <br />
CELSO MARCICANO
</p>

<p class="locador">
CELSO MARCICANO <br />
CIC n.° 038.457.458-00 <br />
Rua Benjamin Constant, 245 <br />
Centro - Ibiúna - SP
</p>
</body>
</html>
