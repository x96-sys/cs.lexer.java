BUILD_DIR     = out
MAIN_BUILD    = $(BUILD_DIR)/main
TEST_BUILD    = $(BUILD_DIR)/test
COVERAGE_DIR  = $(BUILD_DIR)/coverage

SRC_MAIN      = src/main
SRC_TEST      = src/test

LIB_DIR       = lib
TOOL_DIR      = tools

# Dependências
FLUX_VERSION       = 1.0.1
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

CS_VISITOR_VERSION = 0.1.5
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

CS_AST_VERSION = 0.1.2
CS_AST_JAR = $(LIB_DIR)/org.x96.sys.foundation.cs.ast.jar
CS_AST_URL = https://github.com/x96-sys/cs.ast.java/releases/download/v0.1.2/org.x96.sys.foundation.cs.ast.jar

GJF_VERSION   = 1.28.0
GJF_JAR       = $(TOOL_DIR)/google-java-format.jar
GJF_URL       = https://maven.org/maven2/com/google/googlejavaformat/google-java-format/$(GJF_VERSION)/google-java-format-$(GJF_VERSION)-all-deps.jar

JUNIT_VERSION = 1.13.4
JUNIT_JAR     = $(TOOL_DIR)/junit-platform-console-standalone.jar
JUNIT_URL     = https://maven.org/maven2/org/junit/platform/junit-platform-console-standalone/$(JUNIT_VERSION)/junit-platform-console-standalone-$(JUNIT_VERSION).jar


JACOCO_VERSION = 0.8.13
JACOCO_BASE    = https://maven.org/maven2/org/jacoco

JACOCO_CLI_VERSION = $(JACOCO_VERSION)
JACOCO_CLI_JAR     = $(TOOL_DIR)/jacococli.jar
JACOCO_CLI_URL     = $(JACOCO_BASE)/org.jacoco.cli/$(JACOCO_CLI_VERSION)/org.jacoco.cli-$(JACOCO_CLI_VERSION)-nodeps.jar

JACOCO_AGENT_VERSION = $(JACOCO_VERSION)
JACOCO_AGENT_JAR     = $(TOOL_DIR)/jacocoagent-runtime.jar
JACOCO_AGENT_URL     = $(JACOCO_BASE)/org.jacoco.agent/$(JACOCO_AGENT_VERSION)/org.jacoco.agent-$(JACOCO_AGENT_VERSION)-runtime.jar

CP  = $(FLUX_JAR):$(CS_TOKENIZER_JAR):$(CS_TOKEN_JAR):$(CS_LEXER_ENTRY_JAR):$(CS_VISITOR_JAR):$(CS_KIND_JAR):$(CS_TOKEN_JAR):$(CS_ROUTER_JAR):$(CS_AST_JAR)
CPT = $(MAIN_BUILD):$(CP):$(JUNIT_JAR)

# Fontes
JAVA_SOURCES = $(shell find $(SRC_MAIN) -name "*.java")

# Artefato distribuível
DISTRO_JAR = org.x96.sys.foundation.cs.lexer.dsl.jar

build: clean/build libs
	@mkdir -p $(MAIN_BUILD)
	@javac -Xlint:deprecation -d $(MAIN_BUILD) -cp $(CP) $(shell find src/main -name "*.java")

build/test: clean/build/test build
	@javac -Xlint:deprecation -d $(TEST_BUILD) -cp $(CPT) $(shell find src/test -name "*.java")

test: kit build/test build
	@java -jar $(JUNIT_JAR) execute \
	   --class-path $(TEST_BUILD):$(MAIN_BUILD):$(CLI_BUILD):$(CP) \
	   --scan-class-path

test-coverage: clean/coverage
	@echo "📊 Executando testes com cobertura..."
	@java -javaagent:$(JACOCO_AGENT_JAR)=destfile=$(COVERAGE_DIR)/jacoco.exec,excludes=java.*:javax.*:sun.*:jdk.*:com.sun.*:org.junit.* \
	   -jar $(JUNIT_JAR) \
	   execute \
	   --class-path $(TEST_BUILD):$(MAIN_BUILD):$(CLI_BUILD):$(CP) \
	   --scan-class-path

coverage-report: test-coverage
	@echo "📋 Gerando relatório de cobertura..."
	@java -jar $(JACOCO_CLI_JAR) report $(COVERAGE_DIR)/jacoco.exec \
	   --classfiles $(MAIN_BUILD) \
	   --sourcefiles src/main \
	   --html $(COVERAGE_DIR)/html \
	   --xml $(COVERAGE_DIR)/jacoco.xml \
	   --csv $(COVERAGE_DIR)/jacoco.csv
	@echo "✅ Relatório em $(COVERAGE_DIR)/html/index.html"

distro:
	@echo "📦 Criando JAR distribuível..."
	@jar cf $(DISTRO_JAR) -C $(MAIN_BUILD) .
	@echo "✅ JAR criado: $(DISTRO_JAR)"

format:
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

libs: lib/flux lib/cs-token lib/cs-tokenizer lib/cs-lexer-entry lib/cs-lexer-visitor lib/cs-kind lib/cs-router lib/cs-ast

$(eval $(call deps,lib,flux,FLUX))
$(eval $(call deps,lib,cs-token,CS_TOKEN))
$(eval $(call deps,lib,cs-tokenizer,CS_TOKENIZER))
$(eval $(call deps,lib,cs-lexer-entry,CS_LEXER_ENTRY))
$(eval $(call deps,lib,cs-lexer-visitor,CS_VISITOR))
$(eval $(call deps,lib,cs-kind,CS_KIND))
$(eval $(call deps,lib,cs-router,CS_ROUTER))
$(eval $(call deps,lib,cs-ast,CS_AST))

kit: tools/jacoco_cli tools/jacoco_agent

$(eval $(call deps,tools,jacoco_cli,JACOCO_CLI))
$(eval $(call deps,tools,jacoco_agent,JACOCO_AGENT))


kit: tools/junit tools/gjf

$(eval $(call deps,tools,junit,JUNIT))
$(eval $(call deps,tools,gjf,GJF))

$(TEST_BUILD) $(COVERAGE_DIR) $(LIB_DIR) $(TOOL_DIR):
	@mkdir -p $@

clean/build/test:
	@rm -rf $(TEST_BUILD)

clean/build:
	@rm -rf $(MAIN_BUILD)

clean/coverage:
	@rm -rf $(COVERAGE_DIR)

clean:
	@rm -rf $(BUILD_DIR)
	@rm -rf $(LIB_DIR)
	@rm -rf $(TOOL_DIR)



