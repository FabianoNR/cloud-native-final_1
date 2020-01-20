Containerização da Calculadora

Considerando que o docker já está instalado em sua máquina, para rodar a aplicação basta:

Abrir terminal de comando e acessar diretório onde está o arquivo Dockerfile
	diretório: jovens-talentos/2-cloud-native/fabiano-rapkiewicz/tema-06

Usar o Gradle Wrapper para gerar o arquivo a ser feito deploy
	./gradlew clean build	

Criar montar a imagem para rodar o container a apartir do arquivo docker file
	docker build -t "NOME_DA_IMAGEM" .

Rodar um container a partir da imagem criada acima
	docker run -p 8080:8080 "NOME_DA_IMAGEM"
	
*** Os dois passos anteriores que executam comandos docker estão considerando que você tem o nome de usuário adicionado no grupo docker, por isso não houve necessidade do uso de sudo precedendo o comando. Caso você queira evitar de usar sudo toda vez que executar um comando docker, adicione o usuário ao grupo: sudo usermod -aG docker ${USER} 

Acessar via browser o endereço http://localhost:8080 para usar a aplicação da Calculadora
