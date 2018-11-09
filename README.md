# Evaluation

O objetivo deste conjunto de projetos é implementar uma prova de conceito usando Spring Boot, Docker e AWS. A princípio ele não tem objetivo de implementar nada funcional, somente componentes arquiteturais.

## Pré requisitos

- Java 8
- Maven 3.5.3
- Docker
- AWS CLI

## API

## Fila de avaliação

Foi construído um módulo Java para simples consumir uma fila chamada Evaluation. Neste momento o objetivo é testar a chamada da fila por um módulo Unity então a implementação da chamada da API ainda não foi implementada. Sendo assim este módulo só apresenta a mensagem enviada que pode ser um simples texto. Para efeitos de testes não foi utilizado por hora a AWS e sim o ElasticMQ que é um componente que é compatível com o serviço SQS e muito usado para testes de integração e componentes. A forma mais fácil de executar o ElasticMQ é através de uma imagem Docker como no comando abaixo:

docker pull roribio16/alpine-sqs

Para verificar se a imagem está rodando corretamente acesse a seguinte URL:

http://localhost:9325/

Essa URL exibe uma página que pode ser usada para consultar as filas existentes e suas mensagens. Para testar o componente execute o seguinte comando AWS CLI:

aws --endpoint-url http://localhost:9324 sqs send-message --queue-url http://localhost:9324/queue/evaluation-queue --message-body "Hello, queue"

Consulte novamente a página da imagem do ElasticMQ e verifique se a mensagem "Hello, queue"

Feito isso é suficiente para executar os testes usando o SDK do Unity para publicar na fila. Seguem os dados da fila:

Endpoint: http://localhost:9324
Name: evaluation-queue

Informações sobre o SDK do Unity pode ser consultado no seguinte link: https://docs.aws.amazon.com/pt_br/mobile/sdkforunity/developerguide/what-is-unity-plugin.html. Verifique a seção Amazon Simple Queue Service.

### Execução do consumidor de fila (*Não é preciso executar isso para fazer a POC do Unity com SQS)
Com essa mensagens publicadas via linha de comando é possível executar o componente de consumo de fila e verificar as mesmas sendo consumidas. Para isso execute a compilação do projeto a partir do diretório evaluation conforme comando abaixo:

mvn install

Mude para o diretório queue e execute o seguinte comando:

mvn spring-boot:run

Deve aparecer na console o texto da mensagem publicada

## TODO

- Uso de profiles do Spring Boot para suportar vários ambientes
- Implementar a chamada da API Evaluation pelo módulo da fila
- Implementar a chamada de segurança

