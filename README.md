Cloud Native: tema final - parte 1

Esse projeto visa a construção de 3 jobs que devem rodar no servidor de integração contínua Jenkins. Os três jobs estão descritos a seguir:

Job 1 - Build App
	clonado o projeto a partir do Github;
	executado os testes;
	gerado um pacote .war através do build via Gradle;
	publicado o projeto no repositório JFrog Artifactory.

Job 2 - Infra
	buscado pacote .war do do proejto a aprtir do repositório do JFrog Artifactory;
	montado imagem do docker (build) através do Packer;
	provisionado uma máquina virtual através do gerenciador de configurações Ansible;
	enviado imagem docker montada pelo Packer para repositório dockerhub.

Job 3 - Run 
	baixado do repositório dockerhub a imagem do projeto;
	rodado um docker container a partir da imagem recém baixada.

A seguir um vídeo demonstrativo onde é apresentado todo o pipeline descrito acima:
https://youtu.be/algumacoisa


Tecnologias Utilizadas

Jenkins
Docker
Packer
Ansible
Jfrog
Gradle


Pré-requisitos para rodar a aplicação

É necessário que a máquina que irá rodar o pipeline via Jenkins tenha instalado: Jenkins, Docker, Jfrog, Packer e Ansible.

Para instalação do Docker:

https://docs.docker.com/install

Para instalação do Packer:

https://www.packer.io/intro/getting-started/install.html

Para instalação do Jenkins e Jfrog:

para facilitar o uso do JFrog e Jenkins basta executar o script que segue:

	sudo bash jenkins_jfrog.sh

esse script irá disponibilizar um servidor Jenkins e Jfrog rodando respectivamente nas portas 8080 e 8081.



