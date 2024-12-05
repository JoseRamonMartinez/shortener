import { useState } from 'preact/hooks';

const Clipboard = ({ text }) => {
  const [copied, setCopied] = useState(false);

  const copyToClipboard = () => {
    navigator.clipboard
      .writeText(text)
      .then(() => {
        setCopied(true);
        setTimeout(() => {
          setCopied(false);
        }, 2000);
      })
      .catch((error) => {
        alert("Failed to copy: " + error);
      });
  };

  return (
    <button
      id="copyButton"
      onClick={copyToClipboard}
      className="absolute top-4 right-4 hover:text-purple-500 flex items-center gap-2"
    >
      <svg
        id="copyIcon"
        xmlns="http://www.w3.org/2000/svg"
        width="24"
        height="24"
        viewBox="0 0 24 24"
        fill="none"
        stroke="currentColor"
        strokeWidth="2"
        strokeLinecap="round"
        strokeLinejoin="round"
        className="icon icon-tabler icons-tabler-outline icon-tabler-copy transition-opacity duration-300"
        style={{ opacity: copied ? "0" : "1" }}
      >
        <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
        <path
          d="M7 7m0 2.667a2.667 2.667 0 0 1 2.667 -2.667h8.666a2.667 2.667 0 0 1 2.667 2.667v8.666a2.667 2.667 0 0 1 -2.667 2.667h-8.666a2.667 2.667 0 0 1 -2.667 -2.667z"
        ></path>
        <path
          d="M4.012 16.737a2.005 2.005 0 0 1 -1.012 -1.737v-10c0 -1.1 .9 -2 2 -2h10c.75 0 1.158 .385 1.5 1"
        ></path>
      </svg>
      <svg
        id="checkIcon"
        xmlns="http://www.w3.org/2000/svg"
        width="24"
        height="24"
        viewBox="0 0 24 24"
        fill="none"
        stroke="#00C853"
        strokeWidth="2"
        strokeLinecap="round"
        strokeLinejoin="round"
        className="icon icon-tabler icons-tabler-outline icon-tabler-square-rounded-check transition-opacity duration-300"
        style={{
          opacity: copied ? "1" : "0",
          position: "absolute",
          top: "0",
          right: "0",
        }}
      >
        <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
        <path d="M9 12l2 2l4 -4"></path>
        <path d="M12 3c7.2 0 9 1.8 9 9s-1.8 9 -9 9s-9 -1.8 -9 -9s1.8 -9 9 -9z"></path>
      </svg>
    </button>
  );
};

export default Clipboard;
