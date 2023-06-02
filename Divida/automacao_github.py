import subprocess
from github import Github

# Configuração
repo_name = "bruno-sclima/Trab-Pratico-Test-Debt"
issue_title = "Dívida Técnica de Testes"
issue_body = "Issue de Dívida técnica de testes criada automaticamente"
github_token = "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"
minimum_coverage = 87  # Porcentagem mínima de cobertura desejada

# Autenticação no GitHub
g = Github(github_token)
repo = g.get_repo(repo_name)

# Executar os testes com o Maven
test_command = "mvn test"
subprocess.run(test_command, shell=True)

# Gerar o relatório de cobertura com o Maven e o JaCoCo
jacoco_command = "mvn jacoco:report"
subprocess.run(jacoco_command, shell=True)

# Ler o relatório de cobertura
coverage_report_path = "target/site/jacoco/index.html"
with open(coverage_report_path, "r") as report_file:
    coverage_report = report_file.read()

# Obter a porcentagem de cobertura
coverage_percentage = float(coverage_report.split("Total")[1].split(">")[4].split("%")[0])

if coverage_percentage < minimum_coverage:
    # Se a cobertura for menor que a porcentagem mínima, cria a issue
    # com base nos parâmetros fornecidos
    issue = repo.create_issue(issue_title, body=issue_body)
    print(f"Issue criada: {issue.html_url}")
else:
    print("Cobertura de testes adequada. Nenhuma issue será criada.")