#language: pt

Funcionalidade: Gerenciar Contas
	como um usuário autenticado no sistema
	eu quero incluir, alterar e excluir contas
	para que eu possa gerenciar minhas contas a pagar ou receber
	
	Contexto: Autenticação de usuário
		Dado Acessar a página de autenticação do sistema
		E Informar o email "sergio.coti@gmail.com"
		E Informar a senha "@Admin123"
		Quando Solicitar a realização do acesso
		Então Sistema realiza a autenticação com sucesso
		
	Esquema do Cenário: Cadastro de conta com sucesso
		Dado Acessar a página de cadastro de contas
		E Informar o nome da conta <nome>
		E Informar o valor da conta <valor>
		E Informar a data da conta <data>
		E Selecionar o tipo da conta <tipo>
		E Selecionar a categoria da conta <categoria>
		E Informar as observações
		Quando Confirmar a realização do cadastro da conta
		Então Sistema informa que a conta foi criada com sucesso
		
	Exemplos:
		| nome  				    | valor   | data         | tipo              | categoria        |
		| "Salário"  			  | "3000"  | "02/01/2023" | "Conta a Receber" | "TRABALHO"       |
		| "Conta de Luz"    |  "200"  | "03/01/2023" | "Conta a Pagar"   | "DESPESAS FIXAS" |
		| "Mercado"         |  "800"  | "04/01/2023" | "Conta a Pagar"   | "ALIMENTAÇÃO"    |
		| "Plano de Saúde"  |  "600"  | "05/01/2023" | "Conta a Pagar"   | "SAÚDE"          |
		| "Cinema / Filmes" |  "150"  | "06/01/2023" | "Conta a Pagar"   | "LAZER"          |
		| "Bônus de Férias" | "1000"  | "10/01/2023" | "Conta a Receber" | "OUTROS"         |   
		
	Cenário: Atualização de conta com sucesso
		Dado Selecionar uma conta já cadastrada para edição
		E Alterar o nome da conta
		E Alterar o valor da conta
		E Alterar a data da conta
		E Alterar o tipo da conta
		E ALterar a categoria da conta
		E Alterar as observações
		Quando Confirmar a atualização da conta
		Então Sistema informa que a conta foi atualizada com sucesso
		
	Cenário: Deleção de conta com sucesso
		Dado Selecionar uma conta já cadastrada para exclusão
		Quando Confirmar a exclusão da conta
		Então Sistema informa que a conta foi excluída com sucesso