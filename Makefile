.PHONY: all compile run clean help

# Variables
JAVAC = javac
JAVA = java
SRC_DIR = src
BIN_DIR = bin
MAIN_CLASS = calculator.Main
CLASSPATH = $(BIN_DIR)

# Default target
all: compile

# Compile Java source files
compile:
	@echo "Compiling Java source files..."
	@mkdir -p $(BIN_DIR)
	@$(JAVAC) -d $(BIN_DIR) $(SRC_DIR)/calculator/*.java
	@echo "Compilation successful!"

# Run the application
run: compile
	@echo "Starting iOS Calculator..."
	@$(JAVA) -cp $(CLASSPATH) $(MAIN_CLASS)

# Clean compiled files
clean:
	@echo "Cleaning compiled files..."
	@rm -rf $(BIN_DIR)
	@echo "Clean complete!"

# Help target
help:
	@echo "iOS Calculator Makefile"
	@echo ""
	@echo "Available targets:"
	@echo "  make compile  - Compile Java source files"
	@echo "  make run      - Compile and run the calculator"
	@echo "  make clean    - Remove compiled files"
	@echo "  make help     - Display this help message"
	@echo ""
	@echo "Examples:"
	@echo "  make run      - Run the calculator"
	@echo "  make clean    - Clean up compiled files"
