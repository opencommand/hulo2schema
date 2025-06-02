abstract class Command {
    abstract toShell(): string;

    pipe(next: Command): Pipeline {
        return new Pipeline(this, next);
    }

    redirect(output: string): Redirect {
        return new Redirect(this, output);
    }
}

class Sudo extends Command {
    constructor(private cmd: Command) {
        super();
    }

    toShell(): string {
        return `sudo ${this.cmd.toShell()}`;
    }
}

class RawCommand extends Command {
    constructor(private name: string, ...args: string[]) {
        super();
        this.args = args;
    }

    private args: string[];

    toShell(): string {
        return [this.name, ...this.args].join(" ");
    }
}

class Pipeline extends Command {
    constructor(private left: Command, private right: Command) {
        super();
    }

    toShell(): string {
        return `${this.left.toShell()} | ${this.right.toShell()}`;
    }
}

class Redirect extends Command {
    constructor(private cmd: Command, private output: string) {
        super();
    }

    toShell(): string {
        return `${this.cmd.toShell()} > ${this.output}`;
    }
}

const cmd = new Sudo(
    new RawCommand("apt-get", "update")
).pipe(
    new RawCommand("grep", "done")
).redirect("log.txt");

console.log(cmd.toShell());
// sudo apt-get update | grep done > log.txt

class Git extends Command {
    constructor(
        private sub: string,
        private args: string[] = []
    ) { super(); }

    toShell(): string {
        return `git ${this.sub} ${this.args.join(" ")}`;
    }

    static clone(repo: string): Git {
        return new Git("clone", [repo]);
    }

    static commit(msg: string): Git {
        return new Git("commit", ["-m", `"${msg}"`]);
    }
}

const git = Git.clone("https://github.com/foo/bar").pipe(
    Git.commit("init project")
);

console.log(git.toShell());
// git clone https://github.com/foo/bar | git commit -m "init project"
