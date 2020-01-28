# Cloud Native: tema final - parte 1

Esse projeto visa a construção de 3 jobs que devem rodar no servidor de integração contínua Jenkins. Os três jobs estão descritos a seguir:

 - **Job 1 - Build App**
   - clonado o projeto a partir do Github;
   - executado os testes;
   - gerado um pacote .war através do build via Gradle;
   - publicado o projeto no repositório JFrog Artifactory.

 - **Job 2 - Infra**
   - buscado pacote .war do do proejto a aprtir do repositório do JFrog Artifactory;
   - montado imagem do docker (build) através do Packer;
   - provisionado uma máquina virtual através do gerenciador de configurações Ansible;
   - enviado imagem docker montada pelo Packer para repositório dockerhub.

 - **Job 3 - Run** 
   - baixado do repositório dockerhub a imagem do projeto;
   - rodado um docker container a partir da imagem recém baixada.

_[Clique aqui](https://drive.google.com/drive/u/0/my-drive) para assistir um vídeo demonstrativo onde é apresentado todo o pipeline descrito acima._


## Tecnologias Utilizadas

 - Jenkins;
 - Docker;
 - Packer;
 - Ansible;
 - Jfrog;
 - Gradle.


## Pré-requisitos para rodar a aplicação

Necessário que o servidor onde irá rodar o pipeline tenha instalado: Docker, Jenkins, Jfrog, Packer e Ansible.

### Para instalação do Docker:

https://docs.docker.com/install

#### Para instalação do Packer:

https://www.packer.io/intro/getting-started/install.html

#### Para instalação do Jenkins e Jfrog:

Para facilitar o uso do JFrog e do Jenkins basta executar o script que segue:

```
sudo bash jenkins_jfrog.sh
```

O script acima irá disponibilizar o servidor Jenkins na porta **8080** e o Jfrog na porta **8081**.


## Configuração

Para poder rodar o Pipeline completo, é necessário configurar os servidores Jenkins e Artifactory, para isso siga os seguintes passos.

### Artifactory

Acesse a interface do servidor em http://localhost:8081/artifactory;

Faça o login com *usuário e senha default* **admin/password**;

Configure um novo usuário e senha;

Vá para Welcome, *admin > Quick Setup* and crie um repositório Gradle.


### Jenkins

Acesse a interface em http://localhost:8080/jenkins;

Depois acesse no menu lateral a opção *Manage Jenkins >> Manage Plugins*;

Instale os seguintes plugins:
 - Pipeline;
 - GitHub Plugin;
 - Artifactory Plugin.

Com os plugins instalados, acesse a opção *Manage Jenkins >> Configure System* para realizar as seguintes configurações de acesso: 

**Sessão Github**

Role a página até encontrar a opção GitPlugin. Feito isso, entre com o nome de usuário e e-mail usados para acessar a conta do Git. O
endereço específico do repositório será usado na parametrização dos Jobs; 

**Sessão Artifactory**

Role a página até encontrar a opção Artifactory e clique no botão Add. Feito isso, configure a conexão com o servidor Artifactory:

 - No campo Server ID insira um valor para o ID, pode ser por exemplo jfrog;
 - No campo URL insira "http://localhost:8081/artifactory" que é o endereço onde está rodando o servidor Artifactory JFrog;
 - Nos campos da sessão Default Deployer Credentials, configure as credencias de acesso inserindo o mesmo usuário e senha usados para acessar o servidor Artifactory Jfrog.
 - Clique no botão **Salvar** antes de sair da página.

## Rodando Pipeline

Para rodar o Pipeline é necessário antes criar os jobs, conforme segue a baixo;

### Criação de Jobs:

O passo a passo para criação de um job está descrito logo abaixo. Como nesse projeto a pipeline está definida em arquivos Jenkinsfile, os passos devem ser replicados para criação dos outros dois jobs, segue:
  
### Criação do Job Build App
 
1 - Para criação dos jobs, acesse a interface do Jenkins em http://localhost:8080/jenkins;
2 - Acesse "Net Item" localizado o meu lateral;
3 - Entre com um nome para o job, por coerência ao projeto pode ser BuilApp;
4 - Selecione a opção "Pipeline";
5 - Confirme clicando no botão OK;
6 - Role a página até encontrar a sessão Pipeline;
7 - Selecione a opção "Pipeline script from SCM" no campo Definition;
	Selecione a opção Git no campo SCM, ;
	Entre com o endereço https://github.com/fabianorapkiewicz/cloud-native-final_1.git no campo Repository URL; 
8 - Entre com o nome da branch como sendo */master no campo Branch Specifier;
9 - Entre o path "jenkins-jobs/job-buildApp/Jenkinsfile" no campo Script Path;
10- Clicar no botão salvar;

	
### Criação do Job Infra

Repita os passos de criação do Job Build App, modificando os passos 3 e 11 conforme segue: 

3 - Entre com um nome para o job, por coerência ao projeto pode ser Infra;
9 - Entre o path "jenkins-jobs/job-infra/Jenkinsfile" no campo Script Path.

### Criação do Job Run

Repita os passos de criação do Job Build App, modificando os passos 3 e 11 conforme segue: 

3 - Entre com um nome para o job, por coerência ao projeto pode ser Run;
9 - Entre o path "jenkins-jobs/job-run/Jenkinsfile" no campo Script Path.

Após todos Jobs serem criados, basta executálos em ordem para ter todo Pipeline executado e aplicação da calucladora rodando no browser em
http://localhost:8089/calculadora

