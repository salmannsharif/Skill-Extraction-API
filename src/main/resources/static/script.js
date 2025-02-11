document.getElementById('resumeForm').addEventListener('submit', async function (event) {
    event.preventDefault();

    const filePath = document.getElementById('filePath').value;
    const skillsContainer = document.getElementById('skillsContainer');

    // Clear previous results
    skillsContainer.innerHTML = '';

    try {
        const response = await fetch('/api/skills/extract', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ filePath }),
        });

        if (!response.ok) {
            throw new Error('Failed to extract skills');
        }

        const data = await response.json();
        const skills = data.skills;

        if (skills.length === 0) {
            skillsContainer.innerHTML = '<p>No skills found.</p>';
        } else {
            skills.forEach(skill => {
                const skillElement = document.createElement('div');
                skillElement.className = 'skill';
                skillElement.textContent = skill;
                skillsContainer.appendChild(skillElement);
            });
        }
    } catch (error) {
        skillsContainer.innerHTML = `<p style="color: red;">Error: ${error.message}</p>`;
    }
});