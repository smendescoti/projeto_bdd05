#language: pt

Funcionalidade: Criar Conta
	como um usuário não cadastrado na aplicação
	eu quero criar uma conta de acesso
	para que eu possa acessar o sistema
	
Cenário: Criação de conta de usuário com sucesso
	Dado Acessar a página de criação de conta
	E Informar o nome do usuário
	E Informar o email do usuário
	E Informar a senha do usuário
	Quando Solicitar a criação da conta
	Então Sistema realiza o cadastro da conta com sucesso