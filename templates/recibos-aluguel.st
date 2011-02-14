<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <!-- Estilos {{{1 -->
    <meta http-equiv="CONTENT-TYPE" content="text/html; charset=iso-8859-1">
    <title>Recibos de Aluguel</title>
    <style type="text/css">
        @@page {
            size: a4;
        }
        body {
            font-family: "Arial";
            font-size: 10pt;
            text-align: justify;
            line-height: 1.25em;
            margin: 0 2cm;
        }
        div.notas {
            float: left;
            margin: 0;
            padding: 0;
        }
        div.notas p {
            margin: 0.25cm 0 0 0;
            padding: 0;
        }
        table.detalhes {
            font-family: "Arial";
            font-size: 9pt;
            margin-bottom: 0.5cm;
            float: right;
            text-align: right;
        }
        table.detalhes col.desc {
            width: 40em;
        }
        table.detalhes col.valor {
            width: 2cm;
        }
        td {
            margin: 0;
            padding: 0;
        }
        p {
            text-align: justify;
            margin-bottom: 0.4cm;
        }
        h1 {
            font-size: 115%;
            font-weight: bold;
            text-decoration: underline;
            margin-bottom: 0cm;
            text-align: left;
            padding-top: 0.8cm;
        }
        p.principal {
            clear: both;
        }
        p.data {
            text-align: right;
            margin-bottom: 1cm;
        }
        p.assinatura {
            text-align: right;
            margin-bottom: 0;
        }
        div.fim {
            text-align: left;
            margin: 0;
            padding: 0;
        }
        div.fim p {
            margin: 0;
            padding: 0;
        }
        p.periodo {
            text-align: right;
            font-size: 9pt;
        }
        .pbreak {
            display: block;
            clear: both;
            page-break-after: always;
            page-break-after: auto;
        }
    </style>
</head>
<body>
    
<!-- Andrade Alves {{{1 -->
@empy.startDiversion("ANDRADE")

<div class="notas">
    <p><strong>@mes_vcto</strong></p>
</div>

<table class="detalhes">
    <colgroup>
        <col class="desc">
        <col class="valor">
    </colgroup>
    <tr> <td> Valor...R\$ </td>                        <td> 533,50 </td> </tr>
    <tr> <td> - Desconto...R\$ </td>                   <td>   0,00 </td> </tr>
    <tr> <td> + Luz (0,00%)...R\$ </td>                <td>   0,00 </td> </tr>
    <tr> <td> + Água (0,00%)...R\$ </td>               <td>   0,00 </td> </tr>
    <tr> <td> + IPTU 2010 @iptu </td>                 <td>  24,88 </td> </tr>
    <tr> <td> Líquido...R\$ </td>                      <td> 558,38 </td> </tr>
</table>

<p class="principal"> Recebi de ANDRADE ALVES PISOS LTDA. - ME, inscrita no
C.N.P.J.  sob o n.º 08.347.797/0001-00, estabelecida à Av. Ver. Benedito de
Campos, n.° 156-A, Ibiúna, SP, a importância líquida de R\$ 558,38 (quinhentos e
cinqüenta e oito reais e trinta e oito centavos) referente ao aluguel mensal de
um salão comercial no 1.º pavimento do imóvel no endereço acima, vencido em
@vcto, cabendo 33,33% da referida importância líquida a cada locador.</p>

<p>Para maior clareza, firmo o presente.</p>

<p class="data">Ibiúna, @pgto.</p>

<p class="assinatura">
___________________________________ <br />
JOSÉ A. MARCICANO E OUTROS
</p>

<div class="fim">
JOSÉ A. MARCICANO E OUTROS <br />
Avenida Vereador Benedito de Campos, 156 <br />
Centro - Ibiúna - SP
</div>

<p class="periodo">Período do Contrato de Locação: 25/09/2010 a 24/09/2011</p>


@empy.stopDiverting()

<h1>RECIBO DE ALUGUEL DE IMÓVEL</h1>

@empy.replayDiversion("ANDRADE")
<hr />

<h1>AVISO DE ALUGUEL DE IMÓVEL</h1>

@empy.replayDiversion("ANDRADE")
<span class="pbreak"></span>

<!-- Edinéia {{{1 -->
@empy.startDiversion("EDINEIA")

<div class="notas">
    <p><strong>@mes_vcto</strong></p>
</div>

<table class="detalhes">
    <colgroup>
        <col class="desc">
        <col class="valor">
    </colgroup>
    <tr> <td> Valor...R\$ </td>                        <td> 180,00 </td> </tr>
    <tr> <td> - Desconto...R\$ </td>                   <td>   0,00 </td> </tr>
    <tr> <td> + Luz 11/2010 (20,00%)...R\$ </td>       <td>   8,57 </td> </tr>
    <tr> <td> + Agua (20,00%)...R\$ </td>              <td>   5,13 </td> </tr>
    <tr> <td> + IPTU 2010 @iptu </td>                 <td>   8,09 </td> </tr>
    <tr> <td> Líquido...R\$ </td>                      <td> 201,79 </td> </tr>
</table>

<p class="principal"> Recebi de EDINÉIA KELLER DE SOUZA, estabelecida à Av.
Ver. Benedito de Campos, 156, Ibiúna, SP, a importância líquida de R\$
201,79 (duzentos e um reais e setenta e nove centavos) ref. ao aluguel
mensal da sala 4 no 3º pavimento do imóvel no endereço acima, vencido
em @vcto, cabendo 33,33% da referida importância líquida a cada locador.</p>

<p>Para maior clareza, firmo o presente.</p>

<p class="data">Ibiúna, @pgto.</p>

<p class="assinatura">
___________________________________ <br />
JOSÉ A. MARCICANO E OUTROS
</p>

<div class="fim">
JOSÉ A. MARCICANO E OUTROS <br />
Avenida Vereador Benedito de Campos, 156 <br />
Centro - Ibiúna - SP
</div>

<p class="periodo">Período do Contrato de Locação: 01/02/2010 a 31/01/2011</p>

@empy.stopDiverting()

<h1>RECIBO DE ALUGUEL DE IMÓVEL</h1>

@empy.replayDiversion("EDINEIA")
<hr />

<h1>AVISO DE ALUGUEL DE IMÓVEL</h1>

@empy.replayDiversion("EDINEIA")
<span class="pbreak"></span>

<!-- Elizeu {{{1 -->
@empy.startDiversion("ELIZEU")

<div class="notas">
    <p><strong>@mes_vcto</strong></p>
</div>

<table class="detalhes">
    <colgroup>
        <col class="desc">
        <col class="valor">
    </colgroup>
    <tr> <td> Valor...R\$ </td>                        <td> 150,00 </td> </tr>
    <tr> <td> - Desconto...R\$ </td>                   <td>   0,00 </td> </tr>
    <tr> <td> + Luz (10,00%)...R\$ </td>               <td>  32,10 </td> </tr>
    <tr> <td> + Água (10,00%)...R\$ </td>              <td>   5,10 </td> </tr>
    <tr> <td> + IPTU 2010 @iptu </td>                 <td>   8,46 </td> </tr>
    <tr> <td> Líquido...R\$ </td>                      <td> 195,66 </td> </tr>
</table>

<p class="principal"> Recebi de ELIZEU MARCICANO, estabelecido à Av. Ver.
    Benedito de Campos, n.° 156, Ibiúna, SP, a importância líquida de R\$ 195,66
    (cento e noventa e cinco reais e sesssenta e seis centavos) referente ao aluguel
    mensal de uma sala n.º 4 no 2.º pavimento do imóvel no endereço acima,
    vencido em @vcto, cabendo 33,33% da referida importância líquida a cada
    locador.</p>

<p>Para maior clareza, firmo o presente.</p>

<p class="data">Ibiúna, @pgto.</p>

<p class="assinatura">
___________________________________ <br />
JOSÉ A. MARCICANO E OUTROS
</p>

<div class="fim">
JOSÉ A. MARCICANO E OUTROS <br />
Avenida Vereador Benedito de Campos, 156 <br />
Centro - Ibiúna - SP
</div>

<p class="periodo">Período do Contrato de Locação: 01/10/2010 a 30/09/2011</p>

@empy.stopDiverting()

<h1>RECIBO DE ALUGUEL DE IMÓVEL</h1>

@empy.replayDiversion("ELIZEU")
<hr />

<h1>AVISO DE ALUGUEL DE IMÓVEL</h1>

@empy.replayDiversion("ELIZEU")
<span class="pbreak"></span>
<span class="pbreak"></span>

<!-- Lidia {{{1 -->
@empy.startDiversion("LIDIA1")

<div class="notas">
    <p><strong>@lidia_mes_vcto</strong></p>
</div>

<table class="detalhes">
    <colgroup>
        <col class="desc">
        <col class="valor">
    </colgroup>
    <tr> <td> Valor...R\$ </td>                        <td> 915,06 </td> </tr>
    <tr> <td> - Desconto...R\$ </td>                   <td>   0,00 </td> </tr>
    <tr> <td> + Luz (0,00%)...R\$ </td>                <td>   0,00 </td> </tr>
    <tr> <td> + Água (0,00%)...R\$ </td>               <td>   0,00 </td> </tr>
    <tr> <td> + IPTU 2010 @iptu </td>                 <td>  30,60 </td> </tr>
    <tr> <td> Líquido...R\$ </td>                      <td> 945,66 </td> </tr>
</table>

<p class="principal"> Recebi de LÍDIA MEIRE BARRETO LOPES MADEIRAS - ME,
    inscrita no C.N.P.J. sob o n.º 07.333.536/0001-78, estabelecida à Av. Ver.
    Benedito de Campos, n.° 156, Ibiúna, SP, a importância líquida de R\$ 945,66
    (novecentos e quarenta e cinco reais e sessenta e seis centavos) referente
    ao aluguel mensal de um salão comercial no 1.º pavimento do imóvel no
    endereço acima, vencido em @lidia_vcto, cabendo 33,33% da referida
    importância líquida a cada locador.</p>

<p>Para maior clareza, firmo o presente.</p>

<p class="data">Ibiúna, 20 de @mes_pgto.</p>

<p class="assinatura">
___________________________________ <br />
JOSÉ A. MARCICANO E OUTROS
</p>

<div class="fim">
JOSÉ A. MARCICANO E OUTROS <br />
Avenida Vereador Benedito de Campos, 156 <br />
Centro - Ibiúna - SP
</div>

<p class="periodo">Vcto no 20.° dia do 3.º mês subseqüente - Período da Locação: 01/04/2010 a 31/03/2011</p>

@empy.stopDiverting()

<h1>RECIBO DE ALUGUEL DE IMÓVEL</h1>

@empy.replayDiversion("LIDIA1")
<hr />

<h1>AVISO DE ALUGUEL DE IMÓVEL</h1>

@empy.replayDiversion("LIDIA1")
<span class="pbreak"></span>
@empy.startDiversion("LIDIA2")

<div class="notas">
    <p><strong>@mes_vcto</strong></p>
</div>

<table class="detalhes">
    <colgroup>
        <col class="desc">
        <col class="valor">
    </colgroup>
    <tr> <td> Valor...R\$ </td>                        <td> 492,14 </td> </tr>
    <tr> <td> - Desconto...R\$ </td>                   <td>   0,00 </td> </tr>
    <tr> <td> + Luz (0,00%)...R\$ </td>                <td>   0,00 </td> </tr>
    <tr> <td> + Água (0,00%)...R\$ </td>               <td>   0,00 </td> </tr>
    <tr> <td> + IPTU 2010 @iptu </td>                 <td>  30,10 </td> </tr>
    <tr> <td> Líquido...R\$ </td>                      <td> 522,24 </td> </tr>
</table>

<p class="principal"> Recebi de LÍDIA MEIRE BARRETO LOPES MADEIRAS - ME,
    inscrita no C.N.P.J. sob o n.º 07.333.536/0001-78, estabelecida à Av. Ver.
    Benedito de Campos, n.° 156, Ibiúna, SP, a importância líquida de R\$ 522,24
    (quinhentos e vinte e dois reais e vinte e quatro centavos) referente ao
    aluguel mensal de um salão comercial n.° 156-B no 1.º pavimento do imóvel
    no endereço acima, vencido em @vcto, cabendo 33,33% da referida importância
    líquida a cada locador.</p>

<p>Para maior clareza, firmo o presente.</p>

<p class="data">Ibiúna, 10 de @mes_pgto.</p>

<p class="assinatura">
___________________________________ <br />
JOSÉ A. MARCICANO E OUTROS
</p>

<div class="fim">
JOSÉ A. MARCICANO E OUTROS <br />
Avenida Vereador Benedito de Campos, 156 - Centro - Ibiúna - SP
</div>

<p class="periodo">Período do Contrato de Locação: 01/07/2010 a 30/06/2011</p>

@empy.stopDiverting()

<h1>RECIBO DE ALUGUEL DE IMÓVEL</h1>

@empy.replayDiversion("LIDIA2")
<hr />

<h1>AVISO DE ALUGUEL DE IMÓVEL</h1>

@empy.replayDiversion("LIDIA2")
<span class="pbreak"></span>

<!-- Movetaker {{{1 -->
@empy.startDiversion("MOVETAKER")

<div class="notas">
    <p><strong>@mes_vcto</strong></p>
</div>

<table class="detalhes">
    <colgroup>
        <col class="desc">
        <col class="valor">
    </colgroup>
    <tr> <td> Valor...R\$ </td>                        <td> 177,78 </td> </tr>
    <tr> <td> - Desconto...R\$ </td>                   <td>   0,00 </td> </tr>
    <tr> <td> + Luz (0,00%)...R\$ </td>                <td>   0,00 </td> </tr>
    <tr> <td> + Água (0,00%)...R\$ </td>               <td>   0,00 </td> </tr>
    <tr> <td> + Condomínio...R\$ </td>                 <td>  15,00 </td> </tr>
    <tr> <td> + IPTU 2010 @iptu </td>                 <td>   7,95 </td> </tr>
    <tr> <td> Líquido...R\$ </td>                      <td> 200,73 </td> </tr>
</table>

<p class="principal"> Recebi de MOVETAKER COMUNICAÇÃO LTDA., inscrita no
C.N.P.J. sob o n.° 03.251.978/0001-14, estabelecida à Av. Ver. Benedito de
Campos, n.° 156, Ibiúna, SP, a importância líquida de R\$ 200,73 (duzentos
reais e setenta e três centavos) referente ao aluguel mensal de uma sala
n.º 3 no 3.º pavimento do imóvel no endereço acima, vencido em @vcto, cabendo
33,33% da referida importância líquida a cada locador.</p>

<p>Para maior clareza, firmo o presente.</p>

<p class="data">Ibiúna, 10 de @mes_pgto.</p>

<p class="assinatura">
___________________________________ <br />
JOSÉ A. MARCICANO E OUTROS
</p>

<div class="fim">
JOSÉ A. MARCICANO E OUTROS <br />
Avenida Vereador Benedito de Campos, 156 - Centro - Ibiúna - SP
</div>

<p class="periodo">Período do Contrato de Locação: 10/10/2010 a 09/10/2011</p>

@empy.stopDiverting()

<h1>RECIBO DE ALUGUEL DE IMÓVEL</h1>

@empy.replayDiversion("MOVETAKER")
<hr />

<h1>AVISO DE ALUGUEL DE IMÓVEL</h1>

@empy.replayDiversion("MOVETAKER")
<span class="pbreak"></span>

<!-- Fiscont {{{1 -->
@empy.startDiversion("FISCONT")

<div class="notas">
    <p><strong>@mes_vcto</strong></p>
</div>

<table class="detalhes">
    <colgroup>
        <col class="desc">
        <col class="valor">
    </colgroup>
    <tr> <td> Valor...R\$ </td>                        <td> 733,42 </td> </tr>
    <tr> <td> - Desconto...R\$ </td>                   <td>  79,42 </td> </tr>
    <tr> <td> = Líquido...R\$ </td>                    <td> 654,00 </td> </tr>
    <tr> <td> + Luz (40,00%)...R\$ </td>               <td> 134,86 </td> </tr>
    <tr> <td> + Água (30,00%)...R\$ </td>              <td>  15,38 </td> </tr>
    <tr> <td> + IPTU 2010 @iptu </td>                 <td>  38,97 </td> </tr>
    <tr> <td> Líquido...R\$ </td>                      <td> 843,21 </td> </tr>
</table>

<p class="principal" style="line-height: 1em"> Recebi de FISCONT - Ass. Cont. e
    Auditoria Ltda. - ME, inscrita no C.N.P.J. sob o n.° 10.666.623/0001-51,
    estabelecido à Av. Ver.  Benedito de Campos, n.° 156, Ibiúna, SP, a
    importância líquida de R\$ 843,21 (oitocentos e quarenta e três reais 
    e vinte e um centavos), referente ao aluguel mensal de três salas, n.ºs
    1, 2 e 3, no 2.º pavimento do imóvel no endereço acima, vencido em @vcto,
    cabendo 33,33% da referida importância líquida a cada locador.</p>

<p>Para maior clareza, firmo o presente.</p>

<p class="data">Ibiúna, @pgto.</p>

<p class="assinatura">
___________________________________ <br />
JOSÉ A. MARCICANO E OUTROS
</p>

<div class="fim">
JOSÉ A. MARCICANO E OUTROS <br />
Avenida Vereador Benedito de Campos, 156 <br />
Centro - Ibiúna - SP
</div>

<p class="periodo">Período do Contrato de Locação: 13/02/2010 a 12/02/2011</p>

@empy.stopDiverting()

<h1>RECIBO DE ALUGUEL DE IMÓVEL</h1>

@empy.replayDiversion("FISCONT")
<hr />

<h1>AVISO DE ALUGUEL DE IMÓVEL</h1>

@empy.replayDiversion("FISCONT")
<span class="pbreak"></span>

<!-- Construtora Oliveira {{{1 -->
@empy.startDiversion("OLIVEIRA")

<div class="notas">
    <p><strong>@mes_vcto</strong></p>
</div>

<table class="detalhes">
    <colgroup>
        <col class="desc">
        <col class="valor">
    </colgroup>
    <tr> <td> Valor...R\$ </td>                        <td> 180,00 </td> </tr>
    <tr> <td> - Desconto...R\$ </td>                   <td>   0,00 </td> </tr>
    <tr> <td> + Luz (40,00%)...R\$ </td>               <td>   3,67 </td> </tr>
    <tr> <td> + Água (30,00%)...R\$ </td>              <td>   9,85 </td> </tr>
    <tr> <td> + IPTU 2010 @iptu </td>                 <td>   8,46 </td> </tr>
    <tr> <td> Líquido...R\$ </td>                      <td> 201,98 </td> </tr>
</table>

<p class="principal" style="line-height: 1em"> Recebi de CONSTRUTORA OLIVEIRA E
    PRESTAÇÃO DE SERVIÇOS LTDA., inscrita no C.N.P.J. sob o n.°
    10.765.209/0001-08, estabelecido à Av. Ver.  Benedito de Campos, n.° 156,
    Ibiúna, SP, a importância líquida de R\$ 201,98 (duzentos e um reais e
    noventa e oito centavos), referente ao aluguel mensal de uma sala n.º 5 no
    3.º pavimento do imóvel no endereço acima, vencido em @vcto, cabendo 33,33%
    da referida importância líquida a cada locador.</p>

<p>Para maior clareza, firmo o presente.</p>

<p class="data">Ibiúna, @pgto.</p>

<p class="assinatura">
___________________________________ <br />
JOSÉ A. MARCICANO E OUTROS
</p>

<div class="fim">
JOSÉ A. MARCICANO E OUTROS <br />
Avenida Vereador Benedito de Campos, 156 <br />
Centro - Ibiúna - SP
</div>

<p class="periodo">Período do Contrato de Locação: 15/07/2010 a 14/07/2011</p>

@empy.stopDiverting()

<h1>RECIBO DE ALUGUEL DE IMÓVEL</h1>

@empy.replayDiversion("OLIVEIRA")
<hr />

<h1>AVISO DE ALUGUEL DE IMÓVEL</h1>

@empy.replayDiversion("OLIVEIRA")
<span class="pbreak"></span>
</body>
</html>
