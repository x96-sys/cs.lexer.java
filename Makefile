BUILD_DIR     = build
MAIN_BUILD    = $(BUILD_DIR)/main
TEST_BUILD    = $(BUILD_DIR)/test
COVERAGE_DIR  = $(BUILD_DIR)/coverage

SRC_MAIN      = src/main
SRC_TEST      = src/test

TOOL_DIR      = tools
LIB_DIR       = lib

# Dependências
FLUX_VERSION       = 1.0.0
FLUX_JAR           = $(LIB_DIR)/org.x96.sys.foundation.io.jar
FLUX_URL           = https://github.com/x96-sys/flux.java/releases/download/v$(FLUX_VERSION)/org.x96.sys.foundation.io.jar

CS_TOKEN_VERSION = 0.1.3
CS_TOKEN_JAR     = $(LIB_DIR)/org.x96.sys.foundation.cs.lexer.token.jar
CS_TOKEN_URL     = https://github.com/x96-sys/cs.lexer.token.java/releases/download/v0.1.3/org.x96.sys.foundation.cs.lexer.token.jar

CS_TOKENIZER_VERSION = 0.1.6
CS_TOKENIZER_JAR     = $(LIB_DIR)/org.x96.sys.foundation.cs.lexer.tokenizer.jar
CS_TOKENIZER_URL     = https://github.com/x96-sys/cs.lexer.tokenizer.java/releases/download/v$(CS_TOKENIZER_VERSION)/org.x96.sys.foundation.cs.lexer.tokenizer.jar

CS_LEXER_ENTRY_VERSION = 0.1.2
CS_LEXER_ENTRY_JAR     = $(LIB_DIR)/org.x96.sys.foundation.cs.lexer.entry.jar
CS_LEXER_ENTRY_URL     = https://github.com/x96-sys/cs.lexer.visitor.entry.java/releases/download/v$(CS_LEXER_ENTRY_VERSION)/org.x96.sys.foundation.cs.lexer.entry.jar

CS_VISITOR_VERSION = 0.1.2
CS_VISITOR_JAR     = $(LIB_DIR)/org.x96.sys.foundation.cs.lexer.visitor.jar
CS_VISITOR_URL     = https://github.com/x96-sys/cs.lexer.visitor.java/releases/download/v$(CS_VISITOR_VERSION)/org.x96.sys.foundation.cs.lexer.visitor.jar

CS_KIND_VERSION = 0.1.3
CS_KIND_JAR     = $(LIB_DIR)/org.x96.sys.foundation.cs.lexer.token.kind.jar
CS_KIND_URL     = https://github.com/x96-sys/cs.lexer.token.kind.java/releases/download/0.1.3/org.x96.sys.foundation.cs.lexer.token.kind.jar

CS_TOKEN_VERSION = 0.1.3
CS_TOKEN_JAR     = $(LIB_DIR)/org.x96.sys.foundation.cs.lexer.token.jar
CS_TOKEN_URL     = https://github.com/x96-sys/cs.lexer.token.java/releases/download/v0.1.3/org.x96.sys.foundation.cs.lexer.token.jar

CS_ROUTER_VERSION = 0.1.2
CS_ROUTER_JAR     = $(LIB_DIR)/org.x96.sys.foundation.cs.lexer.router.jar
CS_ROUTER_URL     = https://github.com/x96-sys/cs.lexer.router.java/releases/download/v$(CS_ROUTER_VERSION)/org.x96.sys.foundation.cs.lexer.router.jar

JUNIT_VERSION = 1.13.4
JUNIT_JAR     = $(TOOL_DIR)/junit-platform-console-standalone.jar
JUNIT_URL     = https://maven.org/maven2/org/junit/platform/junit-platform-console-standalone/$(JUNIT_VERSION)/junit-platform-console-standalone-$(JUNIT_VERSION).jar

GJF_VERSION   = 1.28.0
GJF_JAR       = $(TOOL_DIR)/google-java-format.jar
GJF_URL       = https://maven.org/maven2/com/google/googlejavaformat/google-java-format/$(GJF_VERSION)/google-java-format-$(GJF_VERSION)-all-deps.jar

JACOCO_VERSION   = 0.8.12
JACOCO_JAR       = $(TOOL_DIR)/jacoco-agent.jar
JACOCO_CLI       = $(TOOL_DIR)/jacoco-cli.jar
JACOCO_AGENT_URL = https://repo1.maven.org/maven2/org/jacoco/org.jacoco.agent/$(JACOCO_VERSION)/org.jacoco.agent-$(JACOCO_VERSION)-runtime.jar
JACOCO_CLI_URL   = https://repo1.maven.org/maven2/org/jacoco/org.jacoco.cli/$(JACOCO_VERSION)/org.jacoco.cli-$(JACOCO_VERSION)-nodeps.jar

# Classpaths
CP  = $(FLUX_JAR):$(CS_TOKENIZER_JAR):$(CS_TOKEN_JAR):$(CS_LEXER_ENTRY_JAR):$(CS_VISITOR_JAR):$(CS_KIND_JAR):$(CS_TOKEN_JAR):$(CS_ROUTER_JAR)
CPT = $(MAIN_BUILD):$(CP):$(JUNIT_JAR)

# Fontes
JAVA_SOURCES = $(shell find $(SRC_DIRS) -name "*.java")

# Artefato distribuível
DISTRO_JAR=org.x96.sys.foundation.cs.visitors.jar

# Alvos principais
all: libs build-main build-test coverage-report distro distro-all-deps

# Builds
build-main:
	@mkdir -p $(MAIN_BUILD)
	@javac -d $(MAIN_BUILD) -cp $(CP) $(shell find src/main -name "*.java")

build-cli: build-main
	@mkdir -p $(CLI_BUILD)
	@javac -d $(CLI_BUILD) -cp $(CP_CLI) $(shell find src/cli -name "*.java" 2>/dev/null || true)

build-test: tools/junit | $(TEST_BUILD)
	@javac -d $(TEST_BUILD) -cp $(CPT) $(shell find src/test -name "*.java")

# Testes
test: build-test
	@java -jar $(JUNIT_JAR) execute \
	   --class-path $(TEST_BUILD):$(MAIN_BUILD):$(CLI_BUILD):$(CP) \
	   --scan-class-path

# Cobertura
test-coverage: build-test tools/jacoco | $(COVERAGE_DIR)
	@echo "📊 Executando testes com cobertura..."
	@java -javaagent:$(JACOCO_JAR)=destfile=$(COVERAGE_DIR)/jacoco.exec,excludes=java.*:javax.*:sun.*:jdk.*:com.sun.*:org.junit.* \
	   -jar $(JUNIT_JAR) \
	   execute \
	   --class-path $(TEST_BUILD):$(MAIN_BUILD):$(CLI_BUILD):$(CP) \
	   --scan-class-path

coverage-report: test-coverage
	@echo "📋 Gerando relatório de cobertura..."
	@java -jar $(JACOCO_CLI) report $(COVERAGE_DIR)/jacoco.exec \
	   --classfiles $(MAIN_BUILD) \
	   --sourcefiles src/main \
	   --html $(COVERAGE_DIR)/html \
	   --xml $(COVERAGE_DIR)/jacoco.xml \
	   --csv $(COVERAGE_DIR)/jacoco.csv
	@echo "✅ Relatório em $(COVERAGE_DIR)/html/index.html"

# Alias para coverage-report
coverage: coverage-report


distro: build-main
	@echo "📦 Criando JAR distribuível..."
	@jar cf $(DISTRO_JAR) -C $(MAIN_BUILD) .
	@echo "✅ JAR criado: $(DISTRO_JAR)"

# JAR com dependências incluídas (all-deps JAR)
distro-all-deps: build-main
	@echo "📦 Criando deps JAR com dependências..."
	@mkdir -p $(BUILD_DIR)/deps-jar
	@cd $(BUILD_DIR)/deps-jar && jar xf ../../$(FLUX_JAR)
	@cd $(BUILD_DIR)/deps-jar && jar xf ../../$(TOKENIZER_JAR)
	@cp -r $(MAIN_BUILD)/* $(BUILD_DIR)/deps-jar/
	@jar cf org.x96.sys.foundation.cs.visitors-deps.jar -C $(BUILD_DIR)/all-deps-jar .
	@echo "✅ deps JAR criado: org.x96.sys.foundation.cs.visitors-all-deps.jar"

# Downloads


tools:
	@mkdir -p $(TOOL_DIR)

tools/junit: tools
	@[ -f $(JUNIT_JAR) ] || (echo "📦 Baixando JUnit..."; curl -L -o $(JUNIT_JAR) $(JUNIT_URL))

tools/gjf: tools
	@[ -f $(GJF_JAR) ] || (echo "📦 Baixando Google Java Format..."; curl -L -o $(GJF_JAR) $(GJF_URL))

tools/jacoco: tools
	@[ -f $(JACOCO_JAR) ] || (echo "📦 Baixando JaCoCo Agent..."; curl -L -o $(JACOCO_JAR) $(JACOCO_AGENT_URL))
	@[ -f $(JACOCO_CLI) ] || (echo "📦 Baixando JaCoCo CLI..."; curl -L -o $(JACOCO_CLI) $(JACOCO_CLI_URL))

# Formatação
format: tools/gjf
	@find src -name "*.java" -print0 | xargs -0 java -jar $(GJF_JAR) --aosp --replace

define deps
$1/$2: $1
	@if [ ! -f "$$($3_JAR)" ]; then \
		echo "[📦] [🚛] [$$($3_VERSION)] [$2]"; \
		curl -sSL -o $$($3_JAR) $$($3_URL); \
	else \
		echo "[📦] [📍] [$$($3_VERSION)] [$2]"; \
	fi
endef

libs: lib/flux lib/cs-token lib/cs-tokenizer lib/cs-lexer-entry lib/cs-lexer-visitor lib/cs-kind lib/cs-router

$(eval $(call deps,lib,flux,FLUX))
$(eval $(call deps,lib,cs-token,CS_TOKEN))
$(eval $(call deps,lib,cs-tokenizer,CS_TOKENIZER))
$(eval $(call deps,lib,cs-lexer-entry,CS_LEXER_ENTRY))
$(eval $(call deps,lib,cs-lexer-visitor,CS_VISITOR))
$(eval $(call deps,lib,cs-kind,CS_KIND))
$(eval $(call deps,lib,cs-router,CS_ROUTER))

$(TEST_BUILD) $(COVERAGE_DIR) $(LIB_DIR):
	@mkdir -p $@

# Limpeza
clean:
	@rm -rf $(BUILD_DIR)
	@rm -rf $(LIB_DIR)
	@rm -rf $(TOOL_DIR)



