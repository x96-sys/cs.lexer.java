BUILD_DIR     = out
MAIN_BUILD    = $(BUILD_DIR)/main
TEST_BUILD    = $(BUILD_DIR)/test

SRC_MAIN      = src/main
SRC_TEST      = src/test

TOOL_DIR      = tools
LIB_DIR       = lib

CS_FLUX_VERSION = 1.0.1
CS_FLUX_JAR     = $(LIB_DIR)/org.x96.sys.foundation.io.jar
CS_FLUX_URL     = https://github.com/x96-sys/flux.java/releases/download/v$(CS_FLUX_VERSION)/org.x96.sys.foundation.io.jar

CS_KIND_VERSION = 0.1.3
CS_KIND_JAR     = $(LIB_DIR)/org.x96.sys.foundation.cs.lexer.token.kind.jar
CS_KIND_URL     = https://github.com/x96-sys/cs.lexer.token.kind.java/releases/download/$(CS_KIND_VERSION)/org.x96.sys.foundation.cs.lexer.token.kind.jar

CS_TOKEN_VERSION = 0.1.3
CS_TOKEN_JAR     = $(LIB_DIR)/org.x96.sys.foundation.cs.lexer.token.jar
CS_TOKEN_URL     = https://github.com/x96-sys/cs.lexer.token.java/releases/download/v$(CS_TOKEN_VERSION)/org.x96.sys.foundation.cs.lexer.token.jar
CS_TOKEN_SHA256  = 7d25aa60fc975b3830bdd07d12dc4717747e03c9e2a94684d110c3238d540752

CS_TOKENIZER_VERSION = 0.1.7
CS_TOKENIZER_JAR     = $(LIB_DIR)/org.x96.sys.foundation.cs.lexer.tokenizer.jar
CS_TOKENIZER_URL     = https://github.com/x96-sys/cs.lexer.tokenizer.java/releases/download/v$(CS_TOKENIZER_VERSION)/org.x96.sys.foundation.cs.lexer.tokenizer.jar

CS_LEXER_ENTRY_VERSION = 0.1.3
CS_LEXER_ENTRY_JAR     = $(LIB_DIR)/org.x96.sys.foundation.cs.lexer.entry.jar
CS_LEXER_ENTRY_URL     = https://github.com/x96-sys/cs.lexer.visitor.entry.java/releases/download/v$(CS_LEXER_ENTRY_VERSION)/org.x96.sys.foundation.cs.lexer.entry.jar

CS_VISITOR_VERSION = 0.1.6
CS_VISITOR_JAR     = $(LIB_DIR)/org.x96.sys.foundation.cs.lexer.visitor.jar
CS_VISITOR_URL     = https://github.com/x96-sys/cs.lexer.visitor.java/releases/download/v$(CS_VISITOR_VERSION)/org.x96.sys.foundation.cs.lexer.visitor.jar

CS_AST_VERSION = 0.2.2
CS_AST_JAR     = $(LIB_DIR)/org.x96.sys.foundation.cs.ast.jar
CS_AST_URL     = https://github.com/x96-sys/cs.ast.java/releases/download/v$(CS_AST_VERSION)/org.x96.sys.foundation.cs.ast.jar

CS_ROUTER_VERSION = 0.1.3
CS_ROUTER_JAR     = $(LIB_DIR)/org.x96.sys.foundation.cs.lexer.router.jar
CS_ROUTER_URL     = https://github.com/x96-sys/cs.lexer.router.java/releases/download/v$(CS_ROUTER_VERSION)/org.x96.sys.foundation.cs.lexer.router.jar

JUNIT_VERSION = 1.13.4
JUNIT_JAR     = $(TOOL_DIR)/junit-platform-console-standalone.jar
JUNIT_URL     = https://maven.org/maven2/org/junit/platform/junit-platform-console-standalone/$(JUNIT_VERSION)/junit-platform-console-standalone-$(JUNIT_VERSION).jar

DISTRO_JAR = org.x96.sys.foundation.cs.lexer.dsl.jar

JAVA_SOURCES := $(shell find $(SRC_MAIN) -name "*.java")
JAVA_TEST_SOURCES := $(shell find $(SRC_TEST) -name "*.java")

CP = $(CS_TOKEN_JAR):$(CS_TOKENIZER_JAR):$(CS_LEXER_ENTRY_JAR):$(CS_VISITOR_JAR):$(CS_KIND_JAR):$(CS_AST_JAR):$(CS_ROUTER_JAR):$(CS_FLUX_JAR)

build: libs clean/build/main
	@javac -d $(MAIN_BUILD) -cp $(CP) $(JAVA_SOURCES)
	@echo "[🦿] [compiled] [$(MAIN_BUILD)]"

build/test: kit clean/build/test build
	@javac -d $(TEST_BUILD) -cp $(JUNIT_JAR):$(MAIN_BUILD):$(CP) $(JAVA_TEST_SOURCES)
	@echo "[🤖] [compiled] [$(TEST_BUILD)] successfully!"

test: build/test
	@java -jar $(JUNIT_JAR) \
     execute \
     --class-path $(TEST_BUILD):$(MAIN_BUILD):$(CP) \
     --scan-class-path

define deps
$1/$2: $1
	@if [ ! -f "$($3_JAR)" ]; then \
		echo "[📦] [🚛] [$($3_VERSION)] [$2]"; \
		curl -sSL -o $($3_JAR) $($3_URL); \
	fi
	@echo "[📦] [📍] [$($3_VERSION)] [$2]";
endef

$(BUILD_DIR) $(MAIN_BUILD) $(TEST_BUILD) $(TOOL_DIR) $(LIB_DIR):
	@mkdir -p $@

libs: \
	$(LIB_DIR)/kind \
	$(LIB_DIR)/token \
	$(LIB_DIR)/tokenizer \
	$(LIB_DIR)/lexer-entry \
	$(LIB_DIR)/visitor \
	$(LIB_DIR)/ast \
	$(LIB_DIR)/router \
	$(LIB_DIR)/flux

$(eval $(call deps,$(LIB_DIR),kind,CS_KIND))
$(eval $(call deps,$(LIB_DIR),token,CS_TOKEN))
$(eval $(call deps,$(LIB_DIR),tokenizer,CS_TOKENIZER))
$(eval $(call deps,$(LIB_DIR),lexer-entry,CS_LEXER_ENTRY))
$(eval $(call deps,$(LIB_DIR),visitor,CS_VISITOR))
$(eval $(call deps,$(LIB_DIR),ast,CS_AST))
$(eval $(call deps,$(LIB_DIR),router,CS_ROUTER))
$(eval $(call deps,$(LIB_DIR),flux,CS_FLUX))

kit: \
	$(TOOL_DIR)/junit

$(eval $(call deps,$(TOOL_DIR),junit,JUNIT))

distro:
	@echo "📦 Criando JAR distribuível..."
	@jar cf $(DISTRO_JAR) -C $(MAIN_BUILD) .
	@echo "✅ JAR criado: $(DISTRO_JAR)"

clean/build:
	@rm -rf $(BUILD_DIR)
	@echo "[🧽] [clean] [$(BUILD_DIR)]"

clean/build/main:
	@rm -rf $(MAIN_BUILD)
	@echo "[🧼] [clean] [$(MAIN_BUILD)]"

clean/build/test:
	@rm -rf $(TEST_BUILD)
	@echo "[🧹] [clean] [$(TEST_BUILD)]"

clean/kit:
	@rm -rf $(TOOL_DIR)
	@echo "[🛀] [clean] [$(TOOL_DIR)]"

clean/libs:
	@rm -rf $(LIB_DIR)
	@echo "[🥽] [clean] [$(LIB_DIR)]"

clean: \
	clean/build \
	clean/build/main \
	clean/build/test \
	clean/kit \
	clean/libs
	@echo "[🔬] [clean]"
