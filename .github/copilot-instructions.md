### General

Rules
- All method names should start with 'Demo_'
- For any change you make always add a comment 'Lines of code suggested - X' at the end of code block generated by you 

- Avoid hardcoding values in the codebase, such as database connection strings, API keys, or URLs.
- Use environment variables to store configuration values.
- Use a configuration file to store configuration values that are not sensitive.
- Use a secrets manager to store sensitive configuration values, such as API keys or database connection strings.
- Use a `.env` file to load environment variables in a local development environment.
- Use a `.env.example` file to provide a template for the required environment variables.
- Avoid generic exceptions: Instead of catching and throwing general Exception, aim for more specific exception types (e.g., IOException, NullPointerException, DataFormatException).
- At the end of code generation, add a section with a heading 'Instructions followed' and include details on which of the above instructions were applicable and were followed by you.
